package com.knifestone.hyena.indicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

import java.util.ArrayList;


/**
 * 简介:灵活的指示器块
 * GitHub https://github.com/KnifeStone.Hyena
 * 邮箱 378741819@qq.com
 *
 * @author KnifeStone
 * @date 2018/01/06
 */
public class HyenaIndicatorBlockFlexible extends BaseHyenaIndicatorBlock {

    private int height;
    private int roundBead;
    private int startColor;
    private int endColor;
    private int marginLeft, marginTop, marginRight, marginBottom;
    private float startX, stopX;

    private Paint paint;
    private RectF rectF = new RectF(startX, 0, stopX, 0);

    public HyenaIndicatorBlockFlexible(Context context) {
        this(context, null);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public HyenaIndicatorBlockFlexible(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HyenaIndicatorBlockFlexible(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.getMode(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setPaintColor();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rectF.set(startX + marginLeft, marginTop, stopX - marginRight, height - marginBottom);
        canvas.drawRoundRect(rectF, roundBead, roundBead, paint);
    }

    public void setColor(int startColor) {
        this.startColor = startColor;
        setPaintColor();
    }

    public void setColorEnd(int endColor) {
        this.endColor = endColor;
        setPaintColor();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setRoundBead(int roundBead) {
        this.roundBead = roundBead;
    }

    public void setPaintColor() {
        if (startColor != 0 && endColor != 0) {
            paint.setShader(new LinearGradient(0, 0, getWidth(), height, startColor, endColor, Shader.TileMode.MIRROR));
        } else if (startColor != 0) {
            paint.setColor(startColor);
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
                end = start + width + positionOffset * 2 * (widthNext + itemMargin);
            } else {
                //左边收缩
                end = start + width + widthNext + itemMargin;
                start = start + (positionOffset - 0.5f) * 2 * (width + itemMargin);
            }
        }
        updateView(start, end);
    }

    public static class Builder {

        private HyenaIndicatorBlockFlexible block;

        private int gravity = Gravity.BOTTOM;

        public Builder(Context context) {
            this.block = new HyenaIndicatorBlockFlexible(context);
        }

        public Builder setColor(@ColorInt int startColor) {
            block.setColor(startColor);
            return this;
        }

        public Builder setColorEnd(@ColorInt int endColor) {
            block.setColorEnd(endColor);
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

        public HyenaIndicatorBlockFlexible builder() {
            FrameLayout.LayoutParams paramsBlock = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            paramsBlock.gravity = gravity;
            block.setLayoutParams(paramsBlock);
            return block;
        }

    }

}
