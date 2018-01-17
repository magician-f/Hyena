package com.test.hyena.ui.base;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.knifestone.hyena.base.fragment.AbnormalFragment;
import com.knifestone.hyena.view.viewgroup.ViewLoading;
import com.test.hyena.R;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-11-23.
 */
public class AbnormalFragmentDemo extends AbnormalFragment {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_abnormal;
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
    protected View createLoadingView() {
        return new ViewLoading(mContext) {
            @Override
            public void bingLayout() {
                LayoutInflater.from(mContext).inflate(R.layout.layout_loading, this);
            }
        };
    }

    @Override
    protected View createEmptyView() {
        TextView textView = new TextView(mContext);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("没有内容");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected View createErrorView() {
        TextView textView = new TextView(mContext);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("错误页面");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
