package com.test.hyena.ui;

import android.text.InputFilter;
import android.widget.EditText;

import com.knifestone.hyena.currency.InputFilterAdapter;
import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/10.
 */
public class CurrencyActivity extends BaseActivity {

    @Override
    protected void initView() {
        InputFilterAdapter();
    }

    @Override
    protected void getData() {

    }

    /**
     * 输入过滤适配器
     */
    private void InputFilterAdapter() {
        EditText etIFA1 = fbid(R.id.etIFA1);
        EditText etIFA2 = fbid(R.id.etIFA2);
        InputFilterAdapter inputFilter;
        //过滤数字和中文
        inputFilter = new InputFilterAdapter.Builder().filterNumber(true).filterChinese(true).builder();
        etIFA1.setFilters(new InputFilter[]{inputFilter});
        //反过滤数字和中文
        inputFilter = new InputFilterAdapter.Builder().filterReverse(true).filterNumber(true).filterChinese(true).builder();
        etIFA2.setFilters(new InputFilter[]{inputFilter});
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_currency;
    }

}
