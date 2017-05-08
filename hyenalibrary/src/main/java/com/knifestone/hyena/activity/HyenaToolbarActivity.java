package com.knifestone.hyena.activity;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.knifestone.hyena.R;

/**
 * 简介:自带工具栏Activity
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class HyenaToolbarActivity extends HyenaBaseActivity {

    private Toolbar toolbar;
    protected FrameLayout viewContent;
    private TextView tvTitle;
    private OnClickListener onClickListenerTopLeft;
    private OnClickListener onClickListenerTopRight;

    private int rightResId;
    private String rightStr;

    @Override
    protected void setContentView() {
        setContentView(bindView());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewContent = (FrameLayout) findViewById(R.id.viewContent);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        //初始化设置 Toolbar
        setSupportActionBar(toolbar);
        if (tvTitle != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        //将继承 TopBarBaseActivity 的布局解析到 FrameLayout 里面
        LayoutInflater.from(this).inflate(getContentView(), viewContent);
    }

    protected void initToolbarDefault(@StringRes int id) {
        initDefault(getString(id));
    }

    protected void initDefault(String title) {
        setTitle(title);
        setTopLeftButton(0, null);
    }

    protected void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            return;
        }
        if (tvTitle != null) {
            tvTitle.setText(title);
        } else {
            toolbar.setTitle(title);
        }
    }

    protected void setTopLeftButton(@DrawableRes int iconResId, OnClickListener onClickListener) {
        this.onClickListenerTopLeft = onClickListener;
        if (iconResId != 0) {
            toolbar.setNavigationIcon(iconResId);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
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

    protected void setTopRightButton(String menuStr, OnClickListener onClickListener) {
        this.rightStr = menuStr;
        this.onClickListenerTopRight = onClickListener;
    }

    protected void setTopRightButton(int menuResId, OnClickListener onClickListener) {
        this.rightResId = menuResId;
        this.onClickListenerTopRight = onClickListener;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (rightResId != 0 || !TextUtils.isEmpty(rightStr)) {
            getMenuInflater().inflate(R.menu.activity_base_toolbar, menu);
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
            // true 告诉系统我们自己处理了点击事件
            return true;
        }
        return false;
    }

    protected abstract int bindView();

    protected abstract int getContentView();

    public interface OnClickListener {
        void onClick();
    }
}
