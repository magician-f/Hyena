package com.test.hyena.base;

import android.view.LayoutInflater;

import com.knifestone.hyena.base.activity.HyenaWhereGoActivity;
import com.knifestone.hyena.view.viewgroup.ViewLoading;
import com.test.hyena.R;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/8.
 */
public abstract class BaseActivity extends HyenaWhereGoActivity {

    @Override
    protected void initViewBefore() {
        initToolbar();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_base_toolbar;
    }

    @Override
    protected void createLoadingView() {
        mViewLoading = new ViewLoading(mContext) {
            @Override
            public void bingLayout() {
                LayoutInflater.from(mContext).inflate(R.layout.layout_loading, this);
            }
        };
    }

    @Override
    protected void onCancelCall() {

    }

    @Override
    protected void cancelLoadingInit() {

    }
}
