package com.test.hyena.ui;

import android.view.LayoutInflater;

import com.knifestone.hyena.base.activity.HyenaWhereGoActivity;
import com.knifestone.hyena.holder.ViewLoading;
import com.test.hyena.R;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-3.
 */
public class TESTActivity extends HyenaWhereGoActivity {

    @Override
    protected int bindLayout() {
        return R.layout.activity_base_toolbar;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_view;
    }

    @Override
    protected void initView() {
//        showAbnormal(null,R.string.app_name,null,null);
        showLoading();
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void createLoadingView() {
        mViewLoading = new ViewLoading(mContext){
            @Override
            public void bingLayout() {
                LayoutInflater.from(getContext()).inflate(R.layout.activity_login,this);
            }
        };
    }

    @Override
    protected void onCancelCall() {

    }
}
