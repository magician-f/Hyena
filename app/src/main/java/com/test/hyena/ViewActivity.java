package com.test.hyena;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.knifestone.hyena.view.button.CountDownButton;

/**
 * 简介:
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by Akita on 2017/5/2.
 */
public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        final CountDownButton countDownButton1 = (CountDownButton) findViewById(R.id.countDownButton1);
        countDownButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownButton1.onStart();
            }
        });
        final CountDownButton countDownButton2 = (CountDownButton) findViewById(R.id.countDownButton2);
        countDownButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownButton2.onStart(100000,8000);
            }
        });
    }
}
