package com.test.hyena.ui.viewpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;


/**
 * 简介:指示器块
 * GitHub https://github.com/KnifeStone.Hyena
 * 邮箱 378741819@qq.com
 *
 * @author KnifeStone
 * @date 2018/01/06
 */
public class ViewPagerIndicatorBlock extends View {

    private int itemHeight;
    private int itemRounded;
    private int startColor;
    private int endColor;
    private float startX, stopX;
    private Paint paint;
    private RectF rectF = new RectF(startX, 0, stopX, 0);

    public ViewPagerIndicatorBlock(Context context, int startColor, int endColor, int itemHeight, int itemRounded) {
        this(context, null);
        this.startColor = startColor;
        this.endColor = endColor;
        this.itemHeight = itemHeight;
        this.itemRounded = itemRounded;
        init();
    }

    public ViewPagerIndicatorBlock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerIndicatorBlock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(itemHeight, MeasureSpec.getMode(heightMeasureSpec));
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
        rectF.set(startX, 0, stopX, itemHeight);
        canvas.drawRoundRect(rectF, itemRounded, itemRounded, paint);
    }

    public void setColor(int startColor, int endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        setPaintColor();
    }

    public void setPaintColor() {
        if (startColor != 0 && endColor != 0) {
            paint.setShader(new LinearGradient(0, 0, getWidth(), itemHeight, startColor, endColor, Shader.TileMode.MIRROR));
        } else if (startColor != 0) {
            paint.setColor(startColor);
        } else {
            paint.setColor(Color.BLACK);
        }
    }

    public void updateView(float startX, float stopX) {
        this.startX = startX;
        this.stopX = stopX;
        invalidate();
    }

}
