package com.test.hyena.ui;

import android.content.Intent;
import android.view.View;

import com.knifestone.hyena.base.activity.HyenaBaseActivity;
import com.knifestone.hyena.function.update.VersionBean;
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
//        File file = new File("file:///storage/emulated/0/Android/data/com.test.hyena/files/Download/version-2.apk".replaceAll("file://", ""));
//        Utils.init(mContext);
//        AppUtils.installApp(file, "update.fileprovider");
//        installApp(this,new File("file:///storage/emulated/0/Android/data/com.test.hyena/files/Download/version.apk"));
//        startActivity(new Intent(this, LoginActivity.class));file:///storage/emulated/0/Android/data/com.test.hyena/files/Download/version-1.apk
        HyenaUpdateActivity.promptUpdate(this, new VersionBean(11, "s", "s", "内容",
                "http://qiniu-app.pgyer.com/f47637880f7f2ad315a6a5e05077c2a1.apk?e=1499910620&attname=app-debug.apk&token=6fYeQ7_TVB5L0QSzosNFfw2HU8eJhAirMF5VxV9G:XfT23m7uu6Nf5h5AwNTTks-jk3c=&sign=a639edd63fe99e9f9242ffe4b4cbc584&t=5966d1dc",
                "2", 0, 0), true, 1);
    }

}
