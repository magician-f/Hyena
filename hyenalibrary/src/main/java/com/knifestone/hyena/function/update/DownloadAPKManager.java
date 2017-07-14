package com.knifestone.hyena.function.update;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;


/**
 * 下载管理器
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-11.
 */
public class DownloadAPKManager {

    /**
     * 查询下载情况
     *
     * @param context
     * @param downId
     * @return
     */
    public DownBean query(Context context, long downId) {
        DownloadManager.Query query = new DownloadManager.Query();
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Cursor cursor = downloadManager.query(query.setFilterById(downId));
        if (cursor == null) {
            return null;
        } else if (cursor.moveToFirst()) {
            //下载的文件在本地的目录
            String localUrl = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
            //下载的文件的下载地址
            String url = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_URI));
            //已经下载的字节数
            int compeleteSize = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
            //总的字节数
            int totalSize = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
            //下载状态
            int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            cursor.close();
            DownBean downInfo = new DownBean(downId, localUrl, url, compeleteSize, totalSize, status);
            return downInfo;
        } else {
            cursor.close();
        }
        return null;
    }

    /**
     * 启动下载
     *
     * @param uri         下载的地址
     * @param title       通知标题
     * @param description 通知详情
     * @return 下载的id
     */
    public long startDownload(Context context, String uri, String title, String description) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(uri));
        //设置只能在wifi网络下下载
//        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        //设置通知可见
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        //设置文件的保存的位置[三种方式]
        //第一种
        //file:///storage/emulated/0/Android/data/your-package/files/Download/update.apk
        request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "version.apk");
        //第二种
        //file:///storage/emulated/0/Download/update.apk
//        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "update.apk");
        //第三种 自定义文件路径
        //request.setDestinationUri()

        // 设置一些基本显示信息
        request.setTitle(title);
        request.setDescription(description);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        //设置下载的文件类型是apk
        request.setMimeType("application/vnd.android.package-archive");

        //加入下载队列
        long downId = downloadManager.enqueue(request);
        return downId;
    }


}
