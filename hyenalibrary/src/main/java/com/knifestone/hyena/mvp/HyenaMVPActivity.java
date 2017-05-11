package com.knifestone.hyena.mvp;

import android.os.Bundle;

import com.knifestone.hyena.base.HyenaBaseActivity;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/11.
 */
public abstract class HyenaMVPActivity<V extends HyenaMVPView> extends HyenaBaseActivity {

    protected V mView;


    @Override
    protected void setContentView() {
        try {
            mView = getViewClass().newInstance();
            mView.init(getLayoutInflater(), null);
            setContentView(mView.getView());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        mView = null;
        super.onDestroy();
    }

    protected abstract Class<V> getViewClass();

}
