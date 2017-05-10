package com.test.hyena.base;

import com.knifestone.hyena.base.HyenaToolbarActivity;
import com.r0adkll.slidr.Slidr;
import com.test.hyena.R;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/8.
 */
public abstract class ToolbarActivity extends HyenaToolbarActivity {

    @Override
    protected void setContentView() {
        super.setContentView();
        Slidr.attach(this);
        initToolbar();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_base_toolbar;
    }

}
