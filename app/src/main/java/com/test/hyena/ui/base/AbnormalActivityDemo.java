package com.test.hyena.ui.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-11-23.
 */
public class AbnormalActivityDemo extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_abnormal;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_where_go,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                showContent();
                break;
            case R.id.menu2:
                showEmpty();
                break;
            case R.id.menu3:
                showLoadingInit();
                break;
            case R.id.menu4:
                showError();
                break;
        }
        return false;
    }


}
