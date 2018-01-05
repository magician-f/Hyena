package com.test.hyena.ui.viewpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;


public class DynamicLineCopy extends View {

    private int lineHeight;
    private int shaderColor;
    private float startX, stopX;
    private Paint paint;
    private RectF rectF = new RectF(startX, 0, stopX, 0);


    public DynamicLineCopy(Context context, int shaderColor, int lineHeight) {
        this(context, null);
        this.shaderColor = shaderColor;
        this.lineHeight = lineHeight;
        init();
    }

    public DynamicLineCopy(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DynamicLineCopy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(shaderColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(lineHeight, MeasureSpec.getMode(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        paint.setShader(new LinearGradient(0, 100, getWidth(), 100, Color.BLACK, Color.RED, Shader.TileMode.MIRROR));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        rectF.set(startX, 0, stopX, lineHeight);
        canvas.drawRoundRect(rectF, lineHeight, lineHeight, paint);
    }

    public void updateView(float startX, float stopX) {
        this.startX = startX;
        this.stopX = stopX;
        invalidate();
    }

}
