package com.test.hyena.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.knifestone.hyena.view.picker.EasyPickerView;
import com.test.hyena.R;
import com.test.hyena.base.ToolbarActivity;

import java.util.ArrayList;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-6-7.
 */
public class EasyPickerActivity extends ToolbarActivity {

    private int hour;
    private int minute;
    private int second;
    private TextView tv;
    private EasyPickerView epvH;
    private EasyPickerView epvM;
    private EasyPickerView epvS;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_easy_picker;
    }

    @Override
    protected void initView() {
        tv = (TextView) findViewById(R.id.tv);
        initHours();
        initMinutes();
        initsecond();
        // btns
        initBtns();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    public void goHttp(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("https://github.com/huzenan/EasyPickerView");
        intent.setData(content_url);
        startActivity(intent);
    }

    private void initHours() {
        epvH = (EasyPickerView) findViewById(R.id.epvH);
        final ArrayList<String> hDataList = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            hDataList.add("" + i);

        epvH.setDataList(hDataList);
        epvH.setOnScrollChangedListener(new EasyPickerView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int curIndex) {
                hour = Integer.parseInt(hDataList.get(curIndex));
                setTv();
            }

            @Override
            public void onScrollFinished(int curIndex) {
                hour = Integer.parseInt(hDataList.get(curIndex));
                setTv();
            }
        });
    }

    private void initMinutes() {
        epvM = (EasyPickerView) findViewById(R.id.epvM);
        final ArrayList<String> dataList2 = new ArrayList<>();
        for (int i = 0; i < 60; i++)
            dataList2.add("" + i);

        epvM.setDataList(dataList2);
        epvM.setOnScrollChangedListener(new EasyPickerView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int curIndex) {
                minute = Integer.parseInt(dataList2.get(curIndex));
                setTv();
            }

            @Override
            public void onScrollFinished(int curIndex) {
                minute = Integer.parseInt(dataList2.get(curIndex));
                setTv();
            }
        });
    }

    private void initsecond() {
        epvS = (EasyPickerView) findViewById(R.id.epvS);
        final ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < 60; i++)
            dataList.add("" + i);

        epvS.setDataList(dataList);
        epvS.setOnScrollChangedListener(new EasyPickerView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int curIndex) {
                second = Integer.parseInt(dataList.get(curIndex));
                setTv();
            }

            @Override
            public void onScrollFinished(int curIndex) {
                second = Integer.parseInt(dataList.get(curIndex));
                setTv();
            }
        });
    }

    private void setTv() {
        tv.setText(hour + "时" + minute + "分" + second + "秒");
    }

    private void initBtns() {
        // hours
        final EditText et_h = (EditText) findViewById(R.id.et_h);

        Button btnTo = (Button) findViewById(R.id.btn_to_h);
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(et_h.getText())) {
                    int index = Integer.parseInt(et_h.getText().toString());
                    epvH.moveTo(index);
                }
            }
        });

        Button btnBy = (Button) findViewById(R.id.btn_by_h);
        btnBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(et_h.getText())) {
                    int index = Integer.parseInt(et_h.getText().toString());
                    epvH.moveBy(index);
                }
            }
        });

    }

}

