package com.knifestone.hyena.function.update;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.knifestone.hyena.R;

/**
 * 简介:检测更新
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-11.
 */
public class CheckUpdateService extends Service {

    /**
     * 提示更新
     *
     * @param context 上下文
     * @param isToast 是否显示toast
     */
    public static void promptUpdate(Context context, boolean isToast, VersionBean bean) {
        Intent intent = new Intent(context, CheckUpdateService.class);
        intent.putExtra("isToast", isToast);
        intent.putExtra("bean", bean);
        context.startService(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return START_NOT_STICKY;
        }
        boolean isToast = intent.getBooleanExtra("isToast", false);
        VersionBean bean = intent.getParcelableExtra("bean");
        if (bean == null) {
            return START_NOT_STICKY;
        }
        /**
         * 判断当前是否是最新版
         */
        if (getAppVersionCode() >= bean.versionCode) {
            //判断是否需要toast
            if (isToast) {
                Toast.makeText(this, getString(R.string.toastNewestVersion), Toast.LENGTH_SHORT).show();
            }
            return START_NOT_STICKY;
        }
        /**
         *  更新策略
         *  0   提示更新
         *  1   对所有低于版本的强制更新
         *  2   对指定版本的强制更新
         *  3   对某个版本以下的强制更新
         */
        switch (bean.strategy) {
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * 获取App版本码
     *
     * @return App版本码
     */
    public int getAppVersionCode() {
        try {
            PackageManager pm = getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
            return pi == null ? -1 : pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
