package com.test.hyena;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.knifestone.hyena.view.button.CountDownButton;
import com.r0adkll.slidr.Slidr;
import com.test.hyena.base.BaseToolbarActivity;

/**
 * 简介:
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by Akita on 2017/5/2.
 */
public class ViewActivity extends BaseToolbarActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_view;
    }

    @Override
    protected void initView() {
        Slidr.attach(this);
        initDefault("常用View");
        final CountDownButton countDownButton = (CountDownButton) findViewById(R.id.countDownButton);
        countDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownButton.onStart();
            }
        });
        countDownButton.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
