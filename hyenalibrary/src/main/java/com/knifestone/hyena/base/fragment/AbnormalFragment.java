package com.knifestone.hyena.base.fragment;

import android.view.View;
import android.view.ViewGroup;

import com.knifestone.hyena.base.IAbnormalView;

/**
 * 简介:
 * 显示loading 异常页面的Fragment
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class AbnormalFragment extends BaseFragment implements IAbnormalView {

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
        if (parent!=null){
            parent.removeView(view);
        }
        contentView.addView(view);
    }

    @Override
    public void cancelAbnormal() {
        if (contentView == null) {
            return;
        }
        contentView.removeAllViews();
    }

    protected abstract View createLoadingView();

    protected abstract View createEmptyView();

    protected abstract View createErrorView();

}
