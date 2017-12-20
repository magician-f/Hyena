package com.knifestone.hyena.base.activity;


import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.knifestone.hyena.R;
import com.knifestone.hyena.base.IAbnormalView;

/**
 * 简介:
 * 显示loading 异常页面的Activity
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class AbnormalActivity extends BaseToolbarActivity implements IAbnormalView {

    protected ViewGroup containerView;
    protected View viewContent;

    @Override
    protected void initContentView() {
        if (bindLayout() != 0) {
            //启用了HyenaToolbarActivity
            setContentView(contentView = LayoutInflater.from(this).inflate(bindLayout(), null));
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            containerView = (ViewGroup) findViewById(R.id.containerView);
            //将继承 ToolBarBaseActivity 的布局解析到 FrameLayout 里面
            viewContent = LayoutInflater.from(this).inflate(getContentLayout(), null);
            containerView.addView(viewContent);
            tvTitle = (TextView) findViewById(R.id.tvTitle);
            //初始化设置 Toolbar
            if (mToolbar != null) {
                setSupportActionBar(mToolbar);
            }
            if (tvTitle != null && getSupportActionBar() != null) {
                //去掉toolbar左边的图标的间距
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        } else {
            //否则整个ToolbarActvity的代码全部垮掉 请忽略
            setContentView(contentView = LayoutInflater.from(this).inflate(getContentLayout(), null));
        }
    }

    @Override
    public void showContent() {
        showAbnormal(viewContent);
    }

    @Override
    public void showLoadingInit() {
        showAbnormal(createLoadingView());
    }

    @Override
    public void showEmpty() {
        showAbnormal(createEmptyView());
    }

    @Override
    public void showError() {
        showAbnormal(createErrorView());
    }

    @Override
    public void showAbnormal(View view) {
        cancelAbnormal();
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        containerView.addView(view);
    }

    @Override
    public void cancelAbnormal() {
        if (containerView == null) {
            return;
        }
        containerView.removeAllViews();
    }

    protected abstract int getContentLayout();

    protected abstract View createLoadingView();

    protected abstract View createEmptyView();

    protected abstract View createErrorView();

}
