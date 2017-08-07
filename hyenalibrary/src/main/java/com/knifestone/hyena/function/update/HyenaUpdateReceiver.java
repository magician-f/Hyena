package com.knifestone.hyena.function.update;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.knifestone.hyena.R;
import com.knifestone.hyena.bean.HyenaDownBean;
import com.knifestone.hyena.utils.AppUtils;


/**
 * 接收下载完成的广播
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-12.
 */
public class HyenaUpdateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        //接收到的广播是下载apk
        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())) {
            long downId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            try {
                DownloadAPKManager manager = new DownloadAPKManager();
                HyenaDownBean bean = manager.query(context, downId);
                //要去判断是否是hynea下载的文件
                if (bean.localUrl.contains(context.getPackageName())) {
                    AppUtils.installApp(context, bean.localUrl.replaceAll("file://", ""), context.getString(R.string.fileprovider));
                }
            } catch (Exception e) {
            }
        }
    }
}

