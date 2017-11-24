package com.knifestone.hyena.base.activity;


import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.knifestone.hyena.R;
import com.knifestone.hyena.view.viewgroup.ViewLoading;

/**
 * 简介:
 * 显示loading 异常页面的Activity
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class HyenaWhereGoActivity extends HyenaToolbarActivity {

    //替换页面
    protected View mViewAbnormal;
    //加载页面
    protected ViewLoading mViewLoading;
    //初始化的加载
    protected boolean isInitLoading;

    public void showLoading() {
        if (viewAbnormalContainer == null) {
            return;
        }
        if (mViewLoading == null) {
            createLoadingView();
            if (mViewLoading != null) {
                viewAbnormalContainer.addView(mViewLoading);
            }
        }
        if (mViewLoading == null) {
            return;
        }
        mViewLoading.setVisibility(View.VISIBLE);
        mViewLoading.onStart();
    }

    public void showLoadingInit() {
        cancelAbnormal();
        cancelContent();
        showLoading();
        isInitLoading = true;
    }

    public boolean isLoading() {
        if (mViewLoading != null && mViewLoading.getVisibility() == View.VISIBLE) {
            return true;
        }
        return false;
    }

    public void cancelLoading() {
        if (viewAbnormalContainer == null) {
            return;
        }
        if (mViewLoading != null) {
            mViewLoading.onStop();
            mViewLoading.setVisibility(View.GONE);
        }
        if (isInitLoading) {
            cancelLoadingInit();
            isInitLoading = false;
        } else {
            if (viewContent != null) {
                viewContent.setVisibility(View.VISIBLE);
            }
        }
    }

    public void showContent() {
        cancelLoading();
        cancelAbnormal();
        if (viewContent != null) {
            viewContent.setVisibility(View.VISIBLE);
        }
    }

    public void cancelContent() {
        if (viewContent != null) {
            viewContent.setVisibility(View.GONE);
        }
    }

    public void showEmpty() {
        showAbnormal(null, getString(R.string.hyenaShowEmpty), null, null);
    }

    public void showRetry() {
        showAbnormal(null, null, getString(R.string.hyenaShowEmpty), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    /**
     * 显示异常
     *
     * @param resImgId 提示图片
     * @param resStrId 提示文字
     * @param resbtnId 按钮文字
     * @param listener 按钮监听
     */
    public void showAbnormal(@DrawableRes Integer resImgId, @StringRes Integer resStrId, @StringRes Integer resbtnId, View.OnClickListener listener) {
        showAbnormal(resImgId, getString(resStrId), getString(resbtnId), listener);
    }

    public void showAbnormal(@DrawableRes Integer resImgId, CharSequence text, CharSequence textBtn, View.OnClickListener listener) {
        cancelLoading();
        cancelContent();
        if (viewAbnormalContainer == null) {
            return;
        }
        if (mViewAbnormal == null) {
            mViewAbnormal = LayoutInflater.from(mContext).inflate(com.knifestone.hyena.R.layout.view_abnormal, null);
            viewAbnormalContainer.addView(mViewAbnormal);
        }
        mViewAbnormal.setVisibility(View.VISIBLE);
        ImageView ivViewEmpty = (ImageView) mViewAbnormal.findViewById(com.knifestone.hyena.R.id.abnormalIv);
        if (resImgId == null) {
            ivViewEmpty.setVisibility(View.GONE);
        } else {
            ivViewEmpty.setVisibility(View.VISIBLE);
            ivViewEmpty.setImageResource(resImgId);
        }
        TextView tvViewEmpty = (TextView) mViewAbnormal.findViewById(com.knifestone.hyena.R.id.abnormalTv);
        if (text == null) {
            tvViewEmpty.setVisibility(View.GONE);
        } else {
            tvViewEmpty.setVisibility(View.VISIBLE);
            tvViewEmpty.setText(text);
        }
        Button btnViewEmpty = (Button) mViewAbnormal.findViewById(com.knifestone.hyena.R.id.abnormalBtn);
        if (listener == null) {
            btnViewEmpty.setVisibility(View.GONE);
            btnViewEmpty.setOnClickListener(null);
        } else {
            btnViewEmpty.setVisibility(View.VISIBLE);
            if (textBtn != null) {
                btnViewEmpty.setText(textBtn);
            }
            btnViewEmpty.setOnClickListener(listener);
        }
    }

    public void cancelAbnormal() {
        if (mViewAbnormal != null) {
            mViewAbnormal.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        if (isLoading()) {
            cancelLoading();
            onCancelCall();
            return;
        }
        super.onBackPressed();
    }

    //创建loading
    protected abstract void createLoadingView();

    //事件传递下去取消请求
    protected abstract void onCancelCall();

    //取消初始化
    protected abstract void cancelLoadingInit();


}
