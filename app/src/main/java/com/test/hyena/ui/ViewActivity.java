package com.test.hyena.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.knifestone.hyena.view.button.CountDownButton;
import com.knifestone.hyena.view.picker.EasyPickerView;
import com.test.hyena.R;
import com.test.hyena.base.ToolbarActivity;

import java.util.ArrayList;

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
        initEasyPickerView();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private void initEasyPickerView() {
        //时
        EasyPickerView epvH = (EasyPickerView) findViewById(R.id.epvH);
        final ArrayList<String> dataList1 = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            dataList1.add("" + i);
        epvH.setDataList(dataList1);
        epvH.setOnScrollChangedListener(new EasyPickerView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int curIndex) {
                //Integer.parseInt(hDataList.get(curIndex));
            }

            @Override
            public void onScrollFinished(int curIndex) {
            }
        });
        //分
        EasyPickerView epvM = (EasyPickerView) findViewById(R.id.epvM);
        final ArrayList<String> dataList2 = new ArrayList<>();
        for (int i = 0; i < 60; i++)
            dataList2.add("" + i);
        epvM.setDataList(dataList2);
        //秒
        EasyPickerView epvS = (EasyPickerView) findViewById(R.id.epvS);
        final ArrayList<String> dataList3 = new ArrayList<>();
        for (int i = 0; i < 60; i++)
            dataList3.add("" + i);
        epvS.setDataList(dataList3);
    }

    public void goHttp(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("https://github.com/huzenan/EasyPickerView");
        intent.setData(content_url);
        startActivity(intent);
    }


}
