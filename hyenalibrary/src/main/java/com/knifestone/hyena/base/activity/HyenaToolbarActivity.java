package com.knifestone.hyena.base.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.knifestone.hyena.R;

/**
 * 简介:可以快速设置Toolbar的Activity
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class HyenaToolbarActivity extends AppCompatActivity {

    protected Toolbar mToolbar;
    protected ViewGroup viewContent;
    protected ViewGroup viewAbnormalContainer;
    private TextView tvTitle;
    private OnClickListener onClickListenerTopLeft;
    private OnClickListener onClickListenerTopRight;

    private int rightResId;
    private CharSequence rightStr;

    /**
     * 上下文
     */
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if (bindLayout() != 0) {
            //启用了HyenaToolbarActivity
            setContentView(bindLayout());
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            viewContent = (ViewGroup) findViewById(R.id.viewContent);
            viewAbnormalContainer = (ViewGroup) findViewById(R.id.viewAbnormalContainer);
            tvTitle = (TextView) findViewById(R.id.tvTitle);
            //初始化设置 Toolbar
            setSupportActionBar(mToolbar);
            if (tvTitle != null && getSupportActionBar() != null) {
                //去掉toolbar左边的图标的间距
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
            //将继承 ToolBarBaseActivity 的布局解析到 FrameLayout 里面
            LayoutInflater.from(this).inflate(getContentLayout(), viewContent);
        }
        else {
            //否则整个ToolbarActvity的代码全部垮掉 请忽略
            setContentView(getContentLayout());
        }
        //重写后可以设置ButterKnife.bind(this);等方法
        initViewBefore();
        initView();
        getData();
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
     * @param iconResId     -1：不要图片 0：使用默认 其它：
     * @param listener      可为null
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

    /**
     * 不需要快速集成Toolbar return 0
     * 需要快速继承Toolbar return 一个完整的布局Id
     */
    protected abstract int bindLayout();

    protected abstract int getContentLayout();

    protected abstract void initViewBefore();

    protected abstract void initView();

    protected abstract void getData();

    public interface OnClickListener {
        void onClick();
    }

}
