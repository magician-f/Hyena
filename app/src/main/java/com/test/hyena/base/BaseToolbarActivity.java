package com.test.hyena.base;

import com.knifestone.hyena.activity.HyenaToolbarActivity;
import com.test.hyena.R;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/8.
 */
public abstract class BaseToolbarActivity extends HyenaToolbarActivity {

    @Override
    protected int bindView() {
        return R.layout.activity_base_toolbar;
    }
}
