package com.knifestone.hyena.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/**
 * 简介:Activity基类
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 上下文
     */
    protected Context mContext;

    /**
     * 标签（打印的时候可以用
     */
    protected String TAG;

    /**
     * 初始化完成Flag
     */
    protected boolean mInitFlag;

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
    abstract void setContentView();


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
     * 快速设置监听
     */
    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        setOnClickListener(findViewById(viewId), listener);
    }

    /**
     * 快速设置监听
     */
    protected void setOnClickListener(View view, View.OnClickListener listener) {
        if (view != null && listener != null) {
            view.setOnClickListener(listener);
        }
    }

    /**
     * 快速打印log
     */
    protected void logD(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d(TAG, msg);
        }
    }

}
