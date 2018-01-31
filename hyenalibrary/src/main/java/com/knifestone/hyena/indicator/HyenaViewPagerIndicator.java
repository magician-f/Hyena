package com.knifestone.hyena.indicator;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
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

import com.knifestone.hyena.R;

import java.util.ArrayList;

/**
 * 简介:ViewPager指示器
 * GitHub https://github.com/KnifeStone.Hyena
 * 邮箱 378741819@qq.com
 *
 * @author KnifeStone
 * @date 2018/01/06
 */
public class HyenaViewPagerIndicator extends HorizontalScrollView {

    protected ViewPager viewPager;
    protected FrameLayout layoutContainer;
    protected String[] titles;
    protected ArrayList<CheckedTextView> textViews = new ArrayList<>();
    protected BaseHyenaIndicatorBlock mBlock;

    protected ColorStateList textColorChecked = null;
    protected int textSizeChecked = 0;
    protected int textSizeNormal = 0;
    protected int itemMargin = 4;
    protected int itemLayout = 0;

    protected int model = MODEL_SPLIT;
    protected final static int MODEL_SPLIT = 0;
    protected final static int MODEL_SORT = 1;
    protected final static int MODEL_CENTER = 2;

    protected OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (viewPager != null) {
                viewPager.setCurrentItem((int) v.getTag());
            }
        }
    };

    public HyenaViewPagerIndicator(Context context) {
        this(context, null);
    }

    public HyenaViewPagerIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HyenaViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
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
        if (textSizeChecked==0 && textSizeNormal!=0){
            textSizeChecked = textSizeNormal;
        }
        itemMargin = array.getDimensionPixelSize(R.styleable.HyenaViewPagerIndex_hyena_item_margin, itemMargin);
        itemLayout = array.getResourceId(R.styleable.HyenaViewPagerIndex_hyena_item_layout, R.layout.hyena_view_indicator_item);
        model = array.getInt(R.styleable.HyenaViewPagerIndex_hyena_index_model, model);

        array.recycle();
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
        initItems();
        setCurrentItem(0);
    }

    public void setViewPager(@NonNull final ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            private int width = 0;
            private int[] location = new int[2];

            @Override
            public void onPageSelected(int position) {
                setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
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
    }

    public void setBlock(@NonNull BaseHyenaIndicatorBlock block) {
        if (viewPager==null){
            throw new NullPointerException("ViewPagerIndicator:ViewPager不能为空，请先设置ViewPager");
        }
        if (mBlock != null) {
            viewPager.removeOnPageChangeListener(mBlock);
            layoutContainer.removeView(mBlock);
        }
        mBlock = block;
        layoutContainer.addView(mBlock,0);
        block.bindingViewPager(viewPager, textViews, itemMargin);
    }

    public String[] getTitles() {
        return titles;
    }

    private void initItems() {
        removeAllViews();
        if (titles == null || titles.length == 0) {
            throw new NullPointerException("ViewPagerIndicator:titles不能是空的");
        }
        layoutContainer = new FrameLayout(getContext());

        LinearLayout layoutText = new LinearLayout(getContext());
        layoutText.setHorizontalGravity(LinearLayout.HORIZONTAL);

        switch (model) {
            case MODEL_SPLIT:
            case MODEL_CENTER:
                setFillViewport(true);
                layoutText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutContainer.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutText.setGravity(Gravity.CENTER);
                break;
            case MODEL_SORT:
                setFillViewport(false);
                layoutText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutContainer.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                layoutText.setGravity(Gravity.CENTER_VERTICAL);
                break;
            default:

                break;
        }
        layoutContainer.addView(layoutText);
        addView(layoutContainer);

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
            if (model == MODEL_SPLIT) {
                params.weight = 1;
            }
            textView.setText(titles[i]);
            textView.setTag(i);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
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
