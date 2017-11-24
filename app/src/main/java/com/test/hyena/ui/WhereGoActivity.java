package com.test.hyena.ui;

import android.view.Menu;
import android.view.MenuItem;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-11-23.
 */
public class WhereGoActivity extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_where_go;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

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
                showLoading();
                break;
            case R.id.menu4:
                showLoadingInit();
                break;
            case R.id.menu5:
                showRetry();
                break;
        }
        return false;
    }
}
