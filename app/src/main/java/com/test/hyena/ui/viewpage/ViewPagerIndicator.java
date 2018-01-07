package com.test.hyena.ui.viewpage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
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
 * 简介:指示器
 * GitHub https://github.com/KnifeStone.Hyena
 * 邮箱 378741819@qq.com
 *
 * @author KnifeStone
 * @date 2018/01/06
 */
public class ViewPagerIndicator extends HorizontalScrollView {

    private ViewPager viewPager;
    private ViewPagerIndicatorBlock indicatorBlock;
    private String[] titles;
    private ArrayList<CheckedTextView> textViews = new ArrayList<>();

    private ColorStateList textColorChecked = null;
    private int textSizeChecked = 0;
    private int textSizeNormal = 0;
    private int itemMargin = 4;
    private int itemLayout = 0;

    private int blockHeight = 8;
    private int blockRounded = 0;
    private int blockMarginBottom = 0;
    private int blockMarginLeftAndRight = 0;
    private int blockColor = 0;
    private int blockEndColor = 0;

    private int model = MODEL_SPLIT;
    private final static int MODEL_SPLIT = 0;
    private final static int MODEL_CASUAL = 1;

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem((int) v.getTag());
        }
    };

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributeSet(context, attrs);
    }

    private void initAttributeSet(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HyenaViewPagerIndex);
        textColorChecked = array.getColorStateList(R.styleable.HyenaViewPagerIndex_hyena_text_color_checked);
        if (textColorChecked == null) {
            textColorChecked = ContextCompat.getColorStateList(getContext(), R.color.hyena_selector_text_color_indicator);
        }
        textSizeChecked = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_text_size_checked, textSizeChecked);
        textSizeNormal = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_text_size_normal, textSizeNormal);
        itemMargin = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_item_margin, itemMargin);
        itemLayout = array.getResourceId(R.styleable.HyenaViewPagerIndex_hyena_item_layout, R.layout.hyena_view_indicator_item);
        blockHeight = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_block_height, blockHeight);
        blockRounded = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_block_rounded, blockRounded);
        blockMarginBottom = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_block_margin_bottom, blockMarginBottom);
        blockMarginLeftAndRight = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_block_margin_left_right, blockMarginLeftAndRight);
        blockColor = array.getColor(R.styleable.HyenaViewPagerIndex_hyena_block_color, blockColor);
        blockEndColor = array.getColor(R.styleable.HyenaViewPagerIndex_hyena_block_end_color, blockEndColor);
        model = array.getInt(R.styleable.HyenaViewPagerIndex_hyena_index_model, model);

        array.recycle();
    }

    public ViewPagerIndicator newData(String[] titles) {
        this.titles = titles;
        initItems();
        setCurrentItem(0);
        return this;
    }

    public ViewPagerIndicator setViewPager(final ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int lastPosition;
            private int width = 0;
            private int widthNext = 0;
            private int left = 0;
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
                left = textViews.get(position).getLeft();
                if (positionOffset == 0f) {
                    //归位
                    start = left;
                    end = left + width;
                } else {
                    if (position + 1 <= textViews.size() - 1) {
                        widthNext = textViews.get(position + 1).getWidth();
                    } else {
                        widthNext = width;
                    }
                    if (positionOffset <= 0.5f) {
                        //向右延伸
                        start = left;
                        end = left + width + positionOffset * 2 * (widthNext + itemMargin);
                    } else {
                        //左边收缩
                        start = left + (positionOffset - 0.5f) * 2 * (width + itemMargin);
                        end = left + width + widthNext + itemMargin;
                    }
                }
                start += blockMarginLeftAndRight;
                end -= blockMarginLeftAndRight;
                indicatorBlock.updateView(start, end);
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
                        if (location[0] + width >= getWidth() - itemMargin) {
                            smoothScrollBy(getWidth() / 2, 0);
                        } else if (location[0] <= itemMargin) {
                            smoothScrollBy(-getWidth() / 2, 0);
                        }
                        break;
                    default:

                        break;
                }
            }
        });
        return this;
    }

    private void initItems() {
        removeAllViews();
        if (titles == null || titles.length == 0) {
            throw new NullPointerException("ViewPagerIndicator:titles不能是空的");
        }
        FrameLayout layout = new FrameLayout(getContext());

        LinearLayout layoutText = new LinearLayout(getContext());
        layoutText.setHorizontalGravity(LinearLayout.HORIZONTAL);

        switch (model) {
            case MODEL_SPLIT:
                setFillViewport(true);
                layoutText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutText.setGravity(Gravity.CENTER);
                break;
            case MODEL_CASUAL:
                setFillViewport(false);
                layoutText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutText.setGravity(Gravity.CENTER_VERTICAL);
                break;
            default:

                break;
        }
        layout.addView(layoutText);

        indicatorBlock = new ViewPagerIndicatorBlock(getContext(), blockColor, blockEndColor, blockHeight, blockRounded);
        FrameLayout.LayoutParams paramsBlock = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        paramsBlock.gravity = Gravity.BOTTOM;
        paramsBlock.setMargins(0, 0, 0, blockMarginBottom);
        indicatorBlock.setLayoutParams(paramsBlock);
        layout.addView(indicatorBlock);

        addView(layout);

        LinearLayout.LayoutParams params;
        CheckedTextView textView;
        for (int i = 0; i < titles.length; i++) {
            textView = (CheckedTextView) LayoutInflater.from(getContext()).inflate(itemLayout, null);
            params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if (i == titles.length - 1) {
                params.setMargins(itemMargin, 0, itemMargin, 0);
            } else {
                params.setMargins(itemMargin, 0, 0, 0);
            }
            textView.setText(titles[i]);
            textView.setTag(i);
            textView.setTextColor(textColorChecked);
            textView.setOnClickListener(onClickListener);
            textViews.add(textView);
            layoutText.addView(textView, params);
        }
    }

    private void setCurrentItem(int index) {
        for (int i = 0; i < textViews.size(); i++) {
            if (i == index) {
                textViews.get(i).setChecked(true);
                if (textSizeChecked != 0) {
                    textViews.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeChecked);
                }
            } else {
                textViews.get(i).setChecked(false);
                if (textSizeNormal != 0) {
                    textViews.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeNormal);
                }
            }
        }
    }

}
