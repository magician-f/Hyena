package com.test.hyena.ui.base;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-11-23.
 */
public class AbnormalFragmentActivityDemo extends BaseActivity {

    private AbnormalFragmentDemo fragment;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_abnormal_fragment;
    }

    @Override
    public void initData(Bundle bundle) {
        fragment = new AbnormalFragmentDemo();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutFrame, fragment).commit();
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        fragment.showContent();
                        break;
                    case R.id.rb2:
                        fragment.showLoadingInit();
                        break;
                    case R.id.rb3:
                        fragment.showEmpty();
                        break;
                    case R.id.rb4:
                        fragment.showError();
                        break;
                }
            }
        });
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

}
