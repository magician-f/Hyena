package com.knifestone.hyena.function.update;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.Utils;
import com.knifestone.hyena.R;

/**
 * 简介:版本升级
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by 杂牌老黑 on 2017/4/17.
 */
public class VersionUpdateActivity extends AppCompatActivity {

    /**
     * 提示更新
     *
     * @param context 上下文
     * @param bean    传入版本数据
     * @param isToast 是否toast
     */
    public static void promptUpdate(Activity context, VersionBean bean, boolean isToast) {
        Intent intent = new Intent(context, VersionUpdateActivity.class);
        intent.putExtra("bean", bean);
        intent.putExtra("isToast", isToast);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context).toBundle());
        } else {
            context.startActivity(intent);
            context.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
        }
    }

    private VersionBean mBean;
    private boolean mIsToast;
    private DownloadAPKManager mManager;

    private TextView updateTvTitle;
    private TextView updateTvContent;
    private Button updateBtnNegative;
    private Button updateBtnPositive;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            VersionBean item = intent.getParcelableExtra("bean");
            if (item != null) {
                mBean = item;
                initView();
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
        if (Utils.getContext() == null) {
            Utils.init(getApplicationContext());
        }
        if (AppUtils.getAppVersionCode() >= mBean.versionCode) {
            //不需要更新
            if (mIsToast) {
                Toast.makeText(this, getString(R.string.toastNewestVersion), Toast.LENGTH_SHORT).show();
            }
            return;
        }

        //
        mManager = new DownloadAPKManager();

        setContentView(R.layout.activity_version_update);
        updateTvTitle = (TextView) findViewById(R.id.updateTvTitle);
        updateTvContent = (TextView) findViewById(R.id.updateTvContent);
        updateBtnNegative = (Button) findViewById(R.id.updateBtnNegative);
        updateBtnPositive = (Button) findViewById(R.id.updateBtnPositive);
        initView();
    }

    protected void initView() {


    }

    @Override
    public void finish() {
        super.finish();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }


}
