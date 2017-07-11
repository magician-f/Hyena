package com.knifestone.hyena.function.update;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class CompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // get complete download id
        long completeDownloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
        // to do here
    }
}

//private CompleteReceiver completeReceiver;
//@Override
//protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.download_manager_demo);
//
//        completeReceiver=new CompleteReceiver();
//        /** register download success broadcast **/
//        registerReceiver(completeReceiver,
//        new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
//        }
//
//@Override
//protected void onDestroy(){
//        super.onDestroy();
//        unregisterReceiver(completeReceiver);
//        }