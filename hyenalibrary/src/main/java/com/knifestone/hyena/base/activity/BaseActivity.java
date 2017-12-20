package com.knifestone.hyena.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.knifestone.hyena.base.IBaseView;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/24
 *     desc  : Activity 基类
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity
        implements IBaseView {

    /**
     * 上次点击时间
     */
    protected long lastClick = 0;

    protected BaseActivity mActivity;

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mContext = this;
        initContentView();
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        initView(savedInstanceState);
        doBusiness();
    }

    protected abstract void initContentView();

    /**
     * 判断是否快速点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= 200) {
            lastClick = now;
            return false;
        }
        return true;
    }

    @Override
    public void onClick(final View view) {
        if (!isFastClick()) onWidgetClick(view);
    }
}
