package com.test.hyena.ui;

import android.content.Intent;
import android.view.View;

import com.knifestone.hyena.base.HyenaBaseActivity;
import com.test.hyena.R;

public class MainActivity extends HyenaBaseActivity {

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

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
