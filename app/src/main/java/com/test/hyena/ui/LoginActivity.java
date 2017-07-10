package com.test.hyena.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;
import com.test.hyena.R;

/**
 * 简介:作者有点懒
 * 描述:这个....
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/26.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etAccount;
    private EditText etPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化
        etAccount = (EditText) findViewById(R.id.etAccount);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //设置 账号输入框过滤emoji、中文
        InputFilterAdapter inputFilter = new InputFilterAdapter
                .Builder()
                .filterEmoji(true)
                .filterChinese(true)
                .builder();
        etAccount.setFilters(new InputFilter[]{inputFilter});
        etPassword.setFilters(new InputFilter[]{inputFilter});

        //设置文本变化监听
        etAccount.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();
            }
        });
        etPassword.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkSubmit();
    }

    /**
     * 检测是否可以提交
     */
    private void checkSubmit() {
        String msg = etAccount.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSubmit.setEnabled(false);
            return;
        }
        msg = etPassword.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSubmit.setEnabled(false);
            return;
        }
        btnSubmit.setEnabled(true);
    }
}
