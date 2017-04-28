package com.akita.hyena.button;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.AttributeSet;


/**
 * 简介:倒计时按钮
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by Akita on 2017/4/28.
 */
public class CountDownButton extends AppCompatButton {

    //默认总时长
    private int mMillisInFutureDefault = 60 * 1000;
    //默认计时间隔
    private int mCountDownIntervalDefault = 1000;

    //系统api 倒计时定时器
    private CountDownTimer mCountDownTimer;
    //按钮文本
    private String mBtnStr;

    public CountDownButton(Context context) {
        super(context);
    }

    public CountDownButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 开始倒计时（默认总时长、默认计时间隔
     */
    public void onStart() {
        onStart(mMillisInFutureDefault, mCountDownIntervalDefault);
    }

    /**
     * 开始倒计时（自定义总时长、默认计时间隔
     *
     * @param millisInFuture 总时长
     */
    public void onStart(long millisInFuture) {
        onStart(millisInFuture, mCountDownIntervalDefault);
    }

    /**
     * 开始倒计时
     *
     * @param millisInFuture    总时长
     * @param countDownInterval 计时间隔
     */
    public void onStart(long millisInFuture, final long countDownInterval) {
        //如果在执行倒计时 退出
        if (isCountDown()) {
            return;
        }
        //保存当前按钮文字
        mBtnStr = getText().toString();
        if (countDownInterval == 0) {
            throw new UnsupportedOperationException("0 作为计时间隔是个糟糕的选择");
        }
        mCountDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {

            private String result;

            @Override
            public void onTick(long millisUntilFinished) {
                result = millisUntilFinished / countDownInterval + "";
                setText(result);
                //设置为不可用
                if (isEnabled()) {
                    setEnabled(false);
                }
            }

            @Override
            public void onFinish() {
                onFinishCountDown();
            }
        };
        mCountDownTimer.start();
    }

    /**
     * 停止倒计时
     */
    public void onStop() {
        if (!isCountDown()) {
            return;
        }
        mCountDownTimer.cancel();
        onFinishCountDown();
    }

    /**
     * 结束倒计时
     */
    private void onFinishCountDown() {
        if (TextUtils.isEmpty(mBtnStr)) {
            mBtnStr = "";
        }
        setText(mBtnStr);
        mCountDownTimer = null;
        setEnabled(true);
    }

    /**
     * 是否在倒计时中
     *
     * @return true：是 false：否
     */
    private boolean isCountDown() {
        return mCountDownTimer != null;
    }

}
