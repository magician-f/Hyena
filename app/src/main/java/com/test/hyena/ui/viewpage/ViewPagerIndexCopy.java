package com.test.hyena.ui.viewpage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.test.hyena.R;

import java.util.ArrayList;

/**
 * 部分思路参考：https://github.com/xujianhui404/ViewPagerFlexTitle/tree/dev-1.0.1
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2018-1-4.
 */
public class ViewPagerIndexCopy extends HorizontalScrollView {

    private ViewPager viewPager;
    private String[] titles;
    private ArrayList<CheckedTextView> textViews = new ArrayList<>();
    private HorizontalScrollView horizontalScrollView;
    private DynamicLineCopy dynamicLine;
    private ColorStateList text_color_checked = null;
    private int text_size_checked;
    private int text_size_normal;
    private int text_margin = 0;
    private int hyena_custom_layout = 0;
    private int model = MODEL_SPLIT;

    private final static int MODEL_SPLIT = 0;
    private final static int MODEL_CASUAL = 1;

    private int lastPosition;

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
//            setCurrentItem((int) v.getTag());
            viewPager.setCurrentItem((int) v.getTag());
        }
    };

    public ViewPagerIndexCopy(Context context) {
        this(context, null);
    }

    public ViewPagerIndexCopy(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerIndexCopy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributeSet(context, attrs);
    }

    private void initAttributeSet(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HyenaViewPagerIndex);
        text_color_checked = array.getColorStateList(R.styleable.HyenaViewPagerIndex_hyena_text_color_checked);
        if (text_color_checked == null) {
            text_color_checked = getResources().getColorStateList(R.color.checked_index_text);
        }
        text_size_checked = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_text_size_checked, 16);
        text_size_normal = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_text_size_normal, 16);
        text_margin = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_text_margin, text_margin);
        hyena_custom_layout = array.getResourceId(R.styleable.HyenaViewPagerIndex_hyena_custom_layout, R.layout.view_index_custom);
        model = array.getInt(R.styleable.HyenaViewPagerIndex_hyena_index_model, model);

//        backgroundColor = array.getColor(R.styleable.ViewPagerTitle_background_content_color, Color.WHITE);
//        itemMargins = array.getDimension(R.styleable.ViewPagerTitle_item_margins, 30);
//
//        shaderColorStart = array.getColor(R.styleable.ViewPagerTitle_line_start_color, Color.parseColor("#ffc125"));
//        shaderColorEnd = array.getColor(R.styleable.ViewPagerTitle_line_end_color, Color.parseColor("#ff4500"));
//        lineHeight = array.getInteger(R.styleable.ViewPagerTitle_line_height, 20);
        array.recycle();
    }

    public ViewPagerIndexCopy newData(String[] titles) {
        this.titles = titles;
        createTextViews(titles);
        setCurrentItem(0);
        return this;
    }

    public ViewPagerIndexCopy setViewPager(final ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int width = 0;
            private int widthNext = 0;
            private int[] location = new int[2];
            private float start = 0;
            private float end = 0;

            /**
             * @param position              当前的位置
             * @param positionOffset        当前滚动比例（左－右／0-1）（右－左／1-0）
             * @param positionOffsetPixels  当前实际滚动的像素（左－右／0-页宽） （右－左／页宽－0）
            被调用的场景： ViewPager滚动时总被回调，这个函数在操作ViewPager时被回调很多次。
            1.手指拖动 action_move 。n次
            2.惯性还原 computeScroll()。n次
            使用场景：做view的动画效果时可以用这个回调函数。
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LogUtils.e("ViewPager:onPageScrolled:position:" + position + ":lastPosition:" + lastPosition + ":positionOffset:" + positionOffset);

                width = textViews.get(position).getWidth();
                textViews.get(position).getLocationInWindow(location);
                if (positionOffset == 0f) {
                    //归位
                    start = location[0];
                    end = location[0] + width;
                } else{
                    if (position + 1 <= textViews.size() - 1) {
                        widthNext = textViews.get(position + 1).getWidth();
                    } else {
                        widthNext = width;
                    }
                    if (positionOffset <= 0.5f) {
                        //向右延伸
                        start = location[0];
                        end = location[0] + width + positionOffset * 2 * (widthNext + text_margin);
                    } else {
                        //左边收缩
                        start = location[0] + (positionOffset - 0.5f) * 2 * (width + text_margin);
                        end = location[0] + width + widthNext + text_margin;
                    }
                }
                dynamicLine.updateView(start, end);
            }

            /**
             * @param position  当前的位置
            被调用的场景：ViewPager确定页面是哪一页时。1次
            1. 手指拖动后抬起 action_up 。1次
            2. 或者手指滑动超出屏幕时 action_cancel。1次
            使用场景：页面切换后改变对应的tab的状态可以用这个回调函数
             */
            @Override
            public void onPageSelected(int position) {
                setCurrentItem(position);
            }

            /**
             * @param state 停止、拖动、归位
             * 被调用的场景：ViewPager状态切换时被调用。这个函数在操作ViewPager时被回调3次。
            1.开始滚动 dragging拖动状态。1次
            2.惯性滚动 settling还原状态。1次
            3.滚动结束 idle空闲状态。1次
            使用场景：做页面状态变化后引起的view特效时可以用这个回调函数
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    //停止
                    case ViewPager.SCROLL_STATE_IDLE:
                        lastPosition = viewPager.getCurrentItem();
                        break;
                    //拖动
                    case ViewPager.SCROLL_STATE_DRAGGING:

                        break;
                    //归位
                    case ViewPager.SCROLL_STATE_SETTLING:
                        width = textViews.get(viewPager.getCurrentItem()).getWidth();
                        textViews.get(viewPager.getCurrentItem()).getLocationInWindow(location);
                        if (location[0] + width >= getWidth() - text_margin) {
                            horizontalScrollView.smoothScrollBy(getWidth() / 2, 0);
                        } else if (location[0] <= text_margin) {
                            horizontalScrollView.smoothScrollBy(-getWidth() / 2, 0);
                        }
                        break;
                }
            }
        });
        return this;
    }

    private void createTextViews(String[] titles) {
        removeAllViews();

        FrameLayout layout = new FrameLayout(getContext());

        horizontalScrollView = new HorizontalScrollView(getContext());
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        LinearLayout layoutText = new LinearLayout(getContext());
        layoutText.setHorizontalGravity(LinearLayout.HORIZONTAL);

        dynamicLine = new DynamicLineCopy(getContext(), Color.BLACK, 20);
        switch (model) {
            case MODEL_SPLIT:
                horizontalScrollView.setFillViewport(true);
                layoutText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutText.setGravity(Gravity.CENTER);
                break;
            case MODEL_CASUAL:
                horizontalScrollView.setFillViewport(false);
                layoutText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutText.setGravity(Gravity.CENTER_VERTICAL);
                break;
        }

        horizontalScrollView.addView(layoutText);
        addView(horizontalScrollView, new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        LayoutParams paramsFrame = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        paramsFrame.gravity = Gravity.BOTTOM;
        dynamicLine.setLayoutParams(paramsFrame);
        addView(dynamicLine);

        LinearLayout.LayoutParams params;
        CheckedTextView textView;
        for (int i = 0; i < titles.length; i++) {
            textView = (CheckedTextView) LayoutInflater.from(getContext()).inflate(hyena_custom_layout, null);
            params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if (i == titles.length - 1) {
                params.setMargins(text_margin, 0, text_margin, 0);
            } else {
                params.setMargins(text_margin, 0, 0, 0);
            }
            textView.setText(titles[i]);
            textView.setTag(i);
            textView.setTextColor(text_color_checked);
            textView.setOnClickListener(onClickListener);
            textViews.add(textView);
            layoutText.addView(textView, params);
        }
    }

    private void setCurrentItem(int index) {
        for (int i = 0; i < textViews.size(); i++) {
            if (i == index) {
                textViews.get(i).setChecked(true);
                textViews.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size_checked);
            } else {
                textViews.get(i).setChecked(false);
                textViews.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size_normal);
            }
        }
    }

}
