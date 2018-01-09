package com.knifestone.hyena.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

import java.util.ArrayList;


/**
 * 简介:简单的指示器块
 * GitHub https://github.com/KnifeStone.Hyena
 * 邮箱 378741819@qq.com
 *
 * @author KnifeStone
 * @date 2018/01/06
 */
public class HyenaIndicatorBlockSimple extends BaseHyenaIndicatorBlock {

    private int height;
    private int roundBead;
    private int color;
    private int marginLeft, marginTop, marginRight, marginBottom;
    private float startX, stopX;

    private Paint paint;
    private RectF rectF = new RectF(startX, 0, stopX, 0);

    public HyenaIndicatorBlockSimple(Context context) {
        this(context, null);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public HyenaIndicatorBlockSimple(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HyenaIndicatorBlockSimple(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.getMode(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rectF.set(startX + marginLeft, marginTop, stopX - marginRight, height - marginBottom);
        canvas.drawRoundRect(rectF, roundBead, roundBead, paint);
    }

    public void setColor(int color) {
        this.color = color;
        setPaintColor();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setRoundBead(int roundBead) {
        this.roundBead = roundBead;
    }

    public void setPaintColor() {
        if (color != 0) {
            paint.setColor(color);
        } else {
            paint.setColor(Color.BLACK);
        }
    }

    public void setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    public void updateView(float startX, float stopX) {
        this.startX = startX;
        this.stopX = stopX;
        invalidate();
    }

    public void bindingViewPager(ViewPager viewPager, ArrayList<CheckedTextView> textViews, int itemMargin) {
        viewPager.addOnPageChangeListener(this);
        this.textViews = textViews;
        this.itemMargin = itemMargin;
    }

    private int width = 0;
    private int widthNext = 0;
    private float start = 0;
    private float end = 0;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (textViews == null || textViews.isEmpty()) {
            return;
        }
        width = textViews.get(position).getWidth();
        start = textViews.get(position).getLeft();
        if (positionOffset == 0f) {
            //归位
            end = start + width;
        } else {
            if (position + 1 <= textViews.size() - 1) {
                widthNext = textViews.get(position + 1).getWidth();
            } else {
                widthNext = width;
            }
            if (positionOffset <= 0.5f) {
                //向右延伸
                start = start + positionOffset * (width + itemMargin);
                end = start + width;
            } else {
                //左边收缩
                start = start + width - Math.abs(1 - positionOffset) * (widthNext + itemMargin);
                end = start + widthNext;
            }
        }
        updateView(start, end);
    }

    public static class Builder {

        private HyenaIndicatorBlockSimple block;

        private int gravity = Gravity.BOTTOM;

        public Builder(Context context) {
            this.block = new HyenaIndicatorBlockSimple(context);
        }

        public Builder setColor(@ColorInt int color) {
            block.setColor(color);
            return this;
        }


        public Builder setHeight(int height) {
            block.setHeight(height);
            return this;
        }

        public Builder setRoundBead(int roundBead) {
            block.setRoundBead(roundBead);
            return this;
        }

        /**
         * 只能设置一次 在构造的时候设置
         *
         * @return
         */
        public Builder setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
            block.setMargin(marginLeft, marginTop, marginRight, marginBottom);
            return this;
        }

        /**
         * 只能设置一次 在构造的时候设置
         *
         * @param gravity
         * @return
         */
        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public HyenaIndicatorBlockSimple builder() {
            FrameLayout.LayoutParams paramsBlock = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            paramsBlock.gravity = gravity;
            block.setLayoutParams(paramsBlock);
            return block;
        }

    }

}
