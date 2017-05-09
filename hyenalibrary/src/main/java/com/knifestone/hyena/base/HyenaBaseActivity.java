package com.knifestone.hyena.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/**
 * 简介:Activity基类
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class HyenaBaseActivity extends AppCompatActivity {

    /**
     * 上下文
     */
    protected Context mContext;

    /**
     * 标签（打印的时候可以用
     */
    protected String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        TAG = "ClassName:" + getClass().getSimpleName() + ":TaskId:" + getTaskId();
        setContentView();
        initView();
        initData(savedInstanceState);
    }

    /**
     * 设置Activity内容
     */
    protected abstract void setContentView();


    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 跳转到目标Activity
     */
    protected void startActivity(Class<?> cl) {
        startActivity(new Intent(this, cl));
    }

    /**
     * 快速findViewById
     */
    protected <T extends View> T fbid(int resId) {
        return (T) super.findViewById(resId);
    }

    /**
     * 快速setOnClickListener
     */
    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        setOnClickListener(findViewById(viewId), listener);
    }

    /**
     * 快速setOnClickListener
     */
    protected void setOnClickListener(View view, View.OnClickListener listener) {
        if (view != null && listener != null) {
            view.setOnClickListener(listener);
        }
    }

    /**
     * 快速log.d
     */
    protected void logD(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d(TAG, msg);
        }
    }

    /**
     * 获得颜色
     */
    public int getColor_(@ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getColor(color);
        } else {
            return getResources().getColor(color);
        }
    }

    /**
     * Activity从后台重新回到前台时被调用
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * Activity创建或者从后台重新回到前台时被调用
     * 在屏幕上对用户可见时调用
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Activity创建或者从被覆盖、后台重新回到前台时被调用
     * Activity开始和用户交互的时候调用，这时该Activity是在Activity栈的顶部 获焦的时候
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Activity窗口获得或失去焦点时被调用,在onResume之后或onPause之后
     *
     * @param hasFocus true获得焦点 false失去焦点
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    /**
     * 在系统准备去启动或者恢复另一个Activity的时候调用。
     * 我们通常会在这个方法中将一些消耗CPU的资源释放掉，以及保存一些关键数据。这个方法的执行一定要快 不然影响切换页面时间
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 退出当前Activity或者跳转到新Activity时被调用
     * Activity被停止或者Activity变成不可见时调用
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 退出当前Activity时被调用,调用之后Activity就结束了
     * Activity被从内存中移除，一般发生在执行finish方法时或者Android回收内存的时候
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 例如:屏幕方向改变时,Activity被销毁再重建;当前Activity处于后台,系统资源紧张将其杀死.
     * 另外,当跳转到其他Activity或者按Home键回到主屏时该方法也会被调用,系统是为了保存当前View组件的状态.
     * 在onPause()之后调用
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * Activity被系统杀死后再重建时被调用.
     * 例如:屏幕方向改变时,Activity被销毁再重建;当前Activity处于后台,系统资源紧张将其杀死,用户又启动该Activity.
     * 这两种情况下onRestoreInstanceState都会被调用,在onStart()之后.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * 当ActivityA的LaunchMode为SingleInstance,SingleTask时,如果已经ActivityA已经在堆栈中，那么此时会调用onNewIntent()方法
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}
