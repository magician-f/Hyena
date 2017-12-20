package com.knifestone.hyena.base.activity;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.knifestone.hyena.R;

/**
 * 简介:可以快速设置Toolbar的Activity
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class BaseToolbarActivity extends BaseActivity {

    /**
     * 当前 Activity 渲染的视图 View
     */
    protected View contentView;
    protected Toolbar mToolbar;
    protected TextView tvTitle;
    private OnClickListener onClickListenerTopLeft;
    private OnClickListener onClickListenerTopRight;

    private int rightResId;
    private CharSequence rightStr;

    @Override
    protected void initContentView() {
        //启用了HyenaToolbarActivity
        setContentView(contentView = LayoutInflater.from(this).inflate(bindLayout(), null));
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        //初始化设置 Toolbar
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        if (tvTitle != null && getSupportActionBar() != null) {
            //去掉toolbar左边的图标的间距
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    /**
     * 一键初始化：
     * 自动设置返回键事件
     * 自动提取AndroidManifest.xml中lable作为Title
     */
    protected void initToolbar() {
        initToolbar(getTitle());
    }

    protected void initToolbar(@StringRes int id) {
        initToolbar(getString(id));
    }

    protected void initToolbar(CharSequence title) {
        setTitle(title);
        setToolbarLeftButton(0, null);
    }

    /**
     * 设置左边图片和监听事件
     *
     * @param iconResId -1：不要图片 0：使用默认 其它：
     * @param listener  可为null
     */
    protected void setToolbarLeftButton(@DrawableRes int iconResId, OnClickListener listener) {
        this.onClickListenerTopLeft = listener;
        if (iconResId == -1) {
            mToolbar.setNavigationIcon(null);
        } else if (iconResId != 0) {
            mToolbar.setNavigationIcon(iconResId);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListenerTopLeft != null) {
                    onClickListenerTopLeft.onClick();
                } else {
                    onBackPressed();
                }
            }
        });
    }

    protected void setToolbarRightButton(CharSequence menuStr, OnClickListener onClickListener) {
        this.rightStr = menuStr;
        this.onClickListenerTopRight = onClickListener;
    }

    protected void setToolbarRightButton(int menuResId, OnClickListener onClickListener) {
        this.rightResId = menuResId;
        this.onClickListenerTopRight = onClickListener;
    }

    @Override
    public void setTitle(CharSequence title) {
        if (title == null) {
            title = "";
        }
        if (tvTitle != null) {
            tvTitle.setText(title);
            return;
        }
        if (getSupportActionBar() != null) {
            super.setTitle(title);
            return;
        }
        if (mToolbar != null) {
            mToolbar.setTitle(title);
            return;
        }
        super.setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (rightResId != 0 || !TextUtils.isEmpty(rightStr)) {
            getMenuInflater().inflate(R.menu.menu_base_toolbar, menu);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (rightResId != 0) {
            menu.findItem(R.id.menu_right).setIcon(rightResId);
        } else if (!TextUtils.isEmpty(rightStr)) {
            menu.findItem(R.id.menu_right).setTitle(rightStr);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_right) {
            onClickListenerTopRight.onClick();
            return true;
        }
        return false;
    }

    protected void startActivity(Class<?> cl) {
        startActivity(new Intent(this, cl));
    }

    protected void startActivity(Class<?> cl, int requestCode) {
        startActivityForResult(new Intent(this, cl), requestCode);
    }

    public interface OnClickListener {
        void onClick();
    }

}
