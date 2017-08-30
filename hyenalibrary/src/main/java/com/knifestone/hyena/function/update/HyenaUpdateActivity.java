package com.knifestone.hyena.function.update;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.knifestone.hyena.R;
import com.knifestone.hyena.bean.HyenaDownBean;
import com.knifestone.hyena.bean.HyenaVersionBean;
import com.knifestone.hyena.utils.AppUtils;


/**
 * 简介:版本升级
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by 杂牌老黑 on 2017/4/17.
 */
public class HyenaUpdateActivity extends Activity {

    /**
     * 启动更新
     *
     * @param context 上下文
     * @param bean    传入版本数据
     * @param isToast 是否toast
     * @param requestCode 页面回调
     */
    public static void launchUpdate(Activity context, HyenaVersionBean bean, boolean isToast, int requestCode) {
        Intent intent = new Intent(context, HyenaUpdateActivity.class);
        intent.putExtra("bean", bean);
        intent.putExtra("isToast", isToast);
        context.startActivityForResult(intent, requestCode);
        context.overridePendingTransition(0, 0);
    }

    private HyenaVersionBean mBean;
    private boolean mIsToast;
    private DownloadAPKManager mManager;

    private TextView updateTvTitle;
    private TextView updateTvContent;
    private ImageView ivClose;
    private ProgressBar updateProgressBar;
    private Button updateBtnNegative;
    private Button updateBtnPositive;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            HyenaVersionBean item = intent.getParcelableExtra("bean");
            if (item != null) {
                mBean = item;
                init();
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Fade());
        }
        //拿到数据
        mBean = getIntent().getParcelableExtra("bean");
        mIsToast = getIntent().getBooleanExtra("isToast", false);
        //安全判断
        if (mBean == null) {
            finish();
            return;
        }
        //判断是否需要更新
        if (AppUtils.getAppVersionCode(this) >= mBean.versionCode) {
            //不需要更新
            if (mIsToast) {
                Toast.makeText(this, getString(R.string.updateNewestVersion), Toast.LENGTH_SHORT).show();
            }
            finish();
            return;
        }
        //设置布局
        setContentView(R.layout.activity_version_update);
        updateTvTitle = (TextView) findViewById(R.id.updateTvTitle);
        updateTvContent = (TextView) findViewById(R.id.updateTvContent);
        ivClose = (ImageView) findViewById(R.id.ivClose);
        updateProgressBar = (ProgressBar) findViewById(R.id.updateProgressBar);
        updateBtnNegative = (Button) findViewById(R.id.updateBtnNegative);
        updateBtnPositive = (Button) findViewById(R.id.updateBtnPositive);
        init();
    }

    private void init() {
        //初始化管理者
        mManager = new DownloadAPKManager();

        updateTvTitle.setText(mBean.title);
        updateTvContent.setText(mBean.content);
        //正常流程

        /**
         *  更新策略
         *  0   提示更新
         *  1   对所有低于版本的强制更新
         *  2   对指定版本的强制更新
         *  3   对某个版本以下的强制更新
         */
        switch (mBean.strategy) {
            case 1:
                strongUpdate();
                break;
            case 2:
                if (AppUtils.getAppVersionCode(this) == mBean.targetCode) {
                    strongUpdate();
                } else {
                    update();
                }
                break;
            case 3:
                if (AppUtils.getAppVersionCode(this) <= mBean.targetCode) {
                    strongUpdate();
                } else {
                    update();
                }
                break;
            default:
                update();
                break;
        }
        if (mBean.downId == 0) {
            return;
        }
        //判断下载状态
        HyenaDownBean downInfo = mManager.query(this, mBean.downId);
        //没有下载记录
        if (downInfo == null) {
            //正常提示
            return;
        }
        switch (downInfo.status) {
            //下载失败
            case DownloadManager.STATUS_FAILED:
                //暂停
            case DownloadManager.STATUS_PAUSED:
                //挂起
            case DownloadManager.STATUS_PENDING:
                //正常提示
                break;
            //下载中
            case DownloadManager.STATUS_RUNNING:
                onLoading();
                break;
            //下载成功
            case DownloadManager.STATUS_SUCCESSFUL:
                onLoadend(downInfo.localUrl);
                break;
        }
    }

    /**
     * 普通更新
     */
    private void update() {
        if (ivClose!=null){
            ivClose.setVisibility(View.VISIBLE);
            ivClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        updateBtnNegative.setText(R.string.updateNegative);
        updateBtnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        updateBtnPositive.setText(R.string.updatePositive);
        updateBtnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //放到后台去下载
                mBean.downId = mManager.startDownload(HyenaUpdateActivity.this, mBean.packageUrl, mBean.title, mBean.content);
                getIntent().putExtra("bean", mBean);
                setResult(RESULT_OK, getIntent());
                finish();
            }
        });
    }

    /**
     * 强制更新
     */
    private void strongUpdate() {
        updateBtnNegative.setVisibility(View.GONE);
        updateBtnPositive.setText(R.string.updatePositive);
        updateBtnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //放到后台去下载
                mBean.downId = mManager.startDownload(HyenaUpdateActivity.this, mBean.packageUrl, mBean.title, mBean.content);
                onLoading();
            }
        });
    }

    private Thread mThread;
    private boolean live;

    /**
     * 下载中
     */
    private void onLoading() {
        updateBtnNegative.setVisibility(View.GONE);
        updateBtnPositive.setVisibility(View.GONE);
        updateProgressBar.setVisibility(View.VISIBLE);
        if (mThread == null) {
            mThread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    live = true;
                    while (live) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        final HyenaDownBean downBean = mManager.query(HyenaUpdateActivity.this, mBean.downId);
                        if (downBean != null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.e("进来,",""+downBean.toString());
                                    updateProgressBar.setMax(downBean.totalSize);
                                    updateProgressBar.setProgress(downBean.compeleteSize);
                                    if (downBean.status == DownloadManager.STATUS_SUCCESSFUL) {
                                        onLoadend(downBean.localUrl);
                                        live = false;
                                    }

                                }
                            });
                        }

                    }
                }
            };
            mThread.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        live = false;
    }

    /**
     * 下载完成
     */
    private void onLoadend(final String localUrl) {
        updateProgressBar.setVisibility(View.GONE);
        updateBtnNegative.setVisibility(View.GONE);
        updateBtnPositive.setVisibility(View.VISIBLE);
        updateBtnPositive.setText(R.string.updateInstall);
        updateBtnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接安装
                AppUtils.installApp(getApplicationContext(), localUrl.replaceAll("file://", ""), "update.fileprovider");
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        /**
         *  更新策略
         *  0   提示更新
         *  1   对所有低于版本的强制更新
         *  2   对指定版本的强制更新
         *  3   对某个版本以下的强制更新
         */
        switch (mBean.strategy) {
            case 1:
                return;
            case 2:
                if (AppUtils.getAppVersionCode(this) == mBean.targetCode) {
                    return;
                }
                break;
            case 3:
                if (AppUtils.getAppVersionCode(this) <= mBean.targetCode) {
                    return;
                }
                break;
        }
        super.onBackPressed();
    }

}
