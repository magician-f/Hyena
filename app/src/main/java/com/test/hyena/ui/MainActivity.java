package com.test.hyena.ui;

import android.content.Intent;
import android.view.View;

import com.knifestone.hyena.base.activity.HyenaBaseActivity;
import com.knifestone.hyena.bean.VersionBean;
import com.knifestone.hyena.function.update.HyenaUpdateActivity;
import com.test.hyena.R;

public class MainActivity extends HyenaBaseActivity {

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

    }

    public void 自定义View(View v) {
        startActivity(new Intent(this, ViewActivity.class));
    }

    public void 通用(View v) {
        startActivity(new Intent(this, CurrencyActivity.class));
    }

    public void 一个优雅的登录页(View v) {
        startActivity(new Intent(this, LoginActivity.class));

    }

    public void APP检测更新升级(View v) {
        VersionBean bean = new VersionBean(
                999,
                "9.9.9",
                "简约新版本袭来",
                "更多的可乐，鸡翅，啤酒\n特别的好",
                "http://bmob-cdn-9047.b0.upaiyun.com/2017/07/15/757cdd9c40b35d1280b0c24209a98f17.apk",
                "2",
                0,
                0);
        HyenaUpdateActivity.launchUpdate(this, bean, true, 1);
    }

}
