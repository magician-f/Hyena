package com.test.hyena.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setToolbarLeftButton(-1, null);
        setTitle("Hyena Android快速开发库");
        setToolbarRightButton(R.mipmap.ic_launcher, new OnClickListener() {
            @Override
            public void onClick() {

            }
        });
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    public void HyenaWhereGoActivity(View v) {
        startActivity(WhereGoActivity.class);
    }

    public void HyenaWhereGoFragmentActivity(View v) {
        startActivity(WhereGoFragmentActivity.class);
    }

    public void 自定义View(View v) {
        startActivity(new Intent(this, ViewActivity.class));
    }

    public void 通用(View v) {
        startActivity(new Intent(this, CurrencyActivity.class));
    }

    public void 一个优雅的登录页(View v) {
        startActivity(new Intent(this, LoginActivity.class));

    }
}
