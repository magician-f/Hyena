package com.test.hyena.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;
import com.test.hyena.ui.scroller.ScrollerActivity;
import com.test.hyena.ui.viewpage.ViewPageIndexWeiBoActivity;

public class MainActivity extends BaseActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setToolbarLeftButton(-1, null);
        setTitle("Hyena Android快速开发库");
        setToolbarRightButton(R.mipmap.ic_launcher, new OnClickListener() {
            @Override
            public void onClick() {

            }
        });
        listView = findViewById(R.id.listView);
        String[] list = getResources().getStringArray(R.array.array_menu_main);
        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        startActivity(WhereGoActivity.class);
                        break;
                    case 1:
                        startActivity(WhereGoFragmentActivity.class);
                        break;
                    case 2:
                        startActivity(ViewActivity.class);
                        break;
                    case 3:
                        startActivity(CurrencyActivity.class);
                        break;
                    case 4:
                        startActivity(LoginActivity.class);
                        break;
                    case 5:
                        startActivity(ScrollerActivity.class);
                        break;
                    case 6:
                        startActivity(ViewPageIndexWeiBoActivity.class);
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
