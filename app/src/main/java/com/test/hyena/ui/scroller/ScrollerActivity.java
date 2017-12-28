package com.test.hyena.ui.scroller;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

/**
 * bolg:http://blog.csdn.net/guolin_blog/article/details/48719871
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-12-28.
 */
public class ScrollerActivity extends BaseActivity {

    private LinearLayout layout;
    private SimpleScrollerView simpleScrollerView;
    private TextView textView;
    private Button btnScrollTo, btnScrollBy;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_scroller;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        layout = findViewById(R.id.layout);
        simpleScrollerView = findViewById(R.id.simpleScrollerView);
        textView = findViewById(R.id.textView);
        btnScrollTo = findViewById(R.id.btnScrollTo);
        btnScrollBy = findViewById(R.id.btnScrollBy);

        simpleScrollerView.setOnClickListener(this);
        btnScrollTo.setOnClickListener(this);
        btnScrollBy.setOnClickListener(this);

        initTextView();
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simpleScrollerView:
                simpleScrollerView.startScroll(-60,0);
                break;
            case R.id.btnScrollTo:
                layout.scrollTo(-10, -10);
                break;
            case R.id.btnScrollBy:
                layout.scrollBy(-10, -5);
                break;
        }
        initTextView();
    }

    @Override
    public void onWidgetClick(View view) {

    }

    private void initTextView() {
        textView.setText(
//                "getLeft：" + textView.getLeft() +
//                        "\ngetTop：" + textView.getTop() +
//                        "\ngetRight：" + textView.getRight() +
//                        "\ngetBottom：" + textView.getBottom() +
//                        "\ngetX：" + textView.getX() +
//                        "\ngetY：" + textView.getY() +
                        "getScrollX:" + layout.getScrollX() +
                        "\ngetScrollY:" + layout.getScrollY());
    }


}
