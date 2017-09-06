package com.test.hyena.ui;

import android.content.Intent;
import android.view.View;

import com.knifestone.hyena.bean.HyenaVersionBean;
import com.knifestone.hyena.function.update.HyenaUpdateActivity;
import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setToolbarLeftButton(-1, null);
        setTitle("Hyena Android快速开发库");
        setToolbarRightButton(R.mipmap.ic_launcher, new OnClickListener() {
            @Override
            public void onClick() {

            }
        });
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

    HyenaVersionBean bean;

    public void 提示更新(View v) {
        if (bean == null) {
            bean = new HyenaVersionBean(
                    999,
                    "9.9.9",
                    "简约新版本袭来",
                    "更多的可乐，鸡翅，啤酒\n特别的好",
                    "http://bmob-cdn-9047.b0.upaiyun.com/2017/07/17/4fde789940d48d038003048e1e39a6e5.apk",
                    "2",
                    0,
                    0,
                    0);
        }
        HyenaUpdateActivity.launchUpdate(this, bean, true, 1);
    }

    public void 强制更新(View v) {
        HyenaVersionBean bean = new HyenaVersionBean(
                999,
                "9.9.9",
                "强制更新",
                "不升级\n就不能用\n珂珂",
                "http://bmob-cdn-9047.b0.upaiyun.com/2017/07/17/4fde789940d48d038003048e1e39a6e5.apk",
                "2",
                1,
                0,
                0);
        HyenaUpdateActivity.launchUpdate(this, bean, true, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    bean = data.getParcelableExtra("bean");
                    break;
            }
        }
    }
}
