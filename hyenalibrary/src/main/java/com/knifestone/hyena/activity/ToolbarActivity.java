package com.knifestone.hyena.activity;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.knifestone.hyena.R;

/**
 * 简介:自带工具栏Activity
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class ToolbarActivity extends BaseActivity {

    protected Toolbar mToolbar;

    /**
     * xml中Toolbar的Id使用 @id/toolbar
     */
    protected void initToolbar(@StringRes int stringId) {
        initToolbar(R.id.toolbar, getString(stringId));
    }

    /**
     * xml中Toolbar的Id使用 @id/toolbar
     */
    protected void initToolbar(String title) {
        initToolbar(R.id.toolbar, title);
    }

    protected void initToolbar(@IdRes int viewId, @StringRes int stringId) {
        initToolbar(viewId, getString(stringId));
    }

    protected void initToolbar(@IdRes int viewId, String title) {
        mToolbar = (Toolbar) findViewById(viewId);
        if (mToolbar == null) {
            throw new IllegalStateException("Exception：xml中没有找到Toolbar");
        }
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
    }
}
