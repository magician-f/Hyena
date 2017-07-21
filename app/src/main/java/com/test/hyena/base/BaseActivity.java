package com.test.hyena.base;

import com.knifestone.hyena.base.activity.HyenaWhereGoActivity;
import com.test.hyena.R;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/8.
 */
public abstract class BaseActivity extends HyenaWhereGoActivity {

    @Override
    protected void setContentView() {
        super.setContentView();
        initToolbar();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_base_toolbar;
    }

    @Override
    protected void createLoadingView() {

    }

    @Override
    protected void onCancelCall() {

    }


}
