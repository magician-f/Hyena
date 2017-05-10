package com.test.hyena.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.knifestone.hyena.view.button.CountDownButton;
import com.test.hyena.R;
import com.test.hyena.base.ToolbarActivity;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/2.
 */
public class ViewActivity extends ToolbarActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_view;
    }

    @Override
    protected void initView() {
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
