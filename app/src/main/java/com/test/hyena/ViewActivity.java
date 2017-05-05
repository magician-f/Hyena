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
        final CountDownButton countDownButton = (CountDownButton) findViewById(R.id.countDownButton);
        countDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始倒计时（默认总时长6*1000、默认计时间隔1000
                countDownButton.onStart();
                //开始倒计时（自定义总时长、默认计时间隔1000
//                countDownButton.onStart(millisInFuture);
                //开始倒计时（自定义总时长、自定义计时间隔
//                countDownButton.onStart(millisInFuture,countDownInterval);
            }
        });
//        countDownButton.onStop();//手动取消
    }
}
