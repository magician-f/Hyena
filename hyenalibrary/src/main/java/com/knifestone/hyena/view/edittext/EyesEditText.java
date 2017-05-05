package com.knifestone.hyena.view.edittext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.knifestone.hyena.R;

/**
 * 简介:带眼睛的输入框
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/4.
 */
public class EyesEditText extends AppCompatEditText {

    /**
     * 显示图片
     */
    private Drawable mDrawableVisibility;
    /**
     * 显示关闭图片
     */
    private Drawable mDrawableVisibilityOff;
    /**
     * 跟随焦点
     */
    private boolean mFollowFocus;

    public EyesEditText(Context context) {
        this(context, null);
    }

    public EyesEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public EyesEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.EyesEditTextStyle);
        if (typedArray == null) {
            return;
        }
        //取图片
        int drawableVisibility = typedArray.getResourceId(R.styleable.EyesEditTextStyle_drawable_visibility, R.drawable.design_ic_visibility);
        int drawableVisibilityOff = typedArray.getResourceId(R.styleable.EyesEditTextStyle_drawable_visibility_off, R.drawable.design_ic_visibility_off);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDrawableVisibility = getContext().getDrawable(drawableVisibility);
            mDrawableVisibilityOff = getContext().getDrawable(drawableVisibilityOff);
        } else {
            mDrawableVisibility = getResources().getDrawable(drawableVisibility);
            mDrawableVisibilityOff = getResources().getDrawable(drawableVisibilityOff);
        }
        if (mDrawableVisibility == null) {
            return;
        }
        mDrawableVisibility.mutate();
        if (mDrawableVisibilityOff == null) {
            return;
        }
        mDrawableVisibilityOff.mutate();

        //取着色
        int color = typedArray.getColor(R.styleable.EyesEditTextStyle_drawable_tint, -1);
        ColorStateList colorStateList = color == -1 ? getTextColors(): ColorStateList.valueOf(color);
        DrawableCompat.setTintList(mDrawableVisibility, colorStateList);
        DrawableCompat.setTintList(mDrawableVisibilityOff, colorStateList);

        //取是否跟随焦点
        mFollowFocus = typedArray.getBoolean(R.styleable.EyesEditTextStyle_drawable_follow_focus, false);

        typedArray.recycle();

        checkDrawableVisible();
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        checkDrawableVisible();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        checkDrawableVisible();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Drawable drawable = getCompoundDrawables()[2];
                if (drawable != null && event.getX() <= (getWidth() - getPaddingRight()) && event.getX() >= (getWidth() - getPaddingRight() - drawable.getBounds().width())) {
                    if (getTransformationMethod() instanceof PasswordTransformationMethod) {
                        setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
                        setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 判断是否显示图片
     */
    private void checkDrawableVisible() {
        if (mFollowFocus) {
            setDrawableVisible(hasFocus() && length() > 0);
        } else {
            setDrawableVisible(length() > 0);
        }
    }

    /**
     * 设置图片显示状态
     */
    private void setDrawableVisible(boolean visible) {
        Drawable drawable;
        if (getTransformationMethod() instanceof PasswordTransformationMethod) {
            drawable = mDrawableVisibility;
        } else {
            drawable = mDrawableVisibilityOff;
        }
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1]
                , visible ? drawable : null, getCompoundDrawables()[3]);
    }
}
