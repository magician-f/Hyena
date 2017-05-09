package com.test.hyena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.knifestone.hyena.base.HyenaBaseActivity;

public class MainActivity extends HyenaBaseActivity {

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    public void 自定义View(View v) {
        startActivity(new Intent(this, ViewActivity.class));
    }
}
