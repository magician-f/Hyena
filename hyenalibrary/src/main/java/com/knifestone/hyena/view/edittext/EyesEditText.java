package com.knifestone.hyena.view.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

    private Drawable mDrawableVisibility;
    private Drawable mDrawableVisibilityOff;

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
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ClearEditTextStyle);
        if (typedArray == null) {
            return;
        }
        int drawableVisibility = typedArray.getResourceId(R.styleable.ClearEditTextStyle_drawable_close, R.drawable.design_ic_visibility);
        int drawableVisibilityOff = typedArray.getResourceId(R.styleable.ClearEditTextStyle_drawable_close, R.drawable.design_ic_visibility_off);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDrawableVisibility = getContext().getDrawable(drawableVisibility);
            mDrawableVisibilityOff = getContext().getDrawable(drawableVisibilityOff);
        } else {
            mDrawableVisibility = getResources().getDrawable(drawableVisibility);
            mDrawableVisibilityOff = getResources().getDrawable(drawableVisibilityOff);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setClearIconVisible(hasFocus() && length() > 0);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        setClearIconVisible(focused && length() > 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Drawable drawable = getCompoundDrawables()[2];
                if (drawable != null && event.getX() <= (getWidth() - getPaddingRight()) && event.getX() >= (getWidth() - getPaddingRight() - drawable.getBounds().width())) {
                    if (getTransformationMethod() instanceof PasswordTransformationMethod){
                        //密码
                        setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }else{
                        //明文
                        setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setClearIconVisible(boolean visible) {
        Drawable drawable = null;
        if (getTransformationMethod() instanceof PasswordTransformationMethod){
            //密码
            drawable = mDrawableVisibility;
        }else{
            //明文
            drawable = mDrawableVisibilityOff;
        }
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1]
                , visible ? drawable : null, getCompoundDrawables()[3]);
    }
}
