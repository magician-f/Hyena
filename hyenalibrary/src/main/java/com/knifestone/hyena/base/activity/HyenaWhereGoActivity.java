package com.knifestone.hyena.base.activity;


import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
        if (viewContent == null || viewAbnormalContainer == null) {
            return;
        }
        if (mViewLoading == null) {
            createLoadingView();
        }
        if (mViewLoading == null) {
            return;
        }
        if (mViewLoading.getParent() != null) {
            return;
        }
        viewAbnormalContainer.setVisibility(View.VISIBLE);
        viewAbnormalContainer.addView(mViewLoading);
        mViewLoading.onStart();
    }

    public void showLoadingInit() {
        showLoading();
        isInitLoading = true;
        viewContent.setVisibility(View.GONE);
    }

    public boolean isLoading() {
        if (mViewLoading != null) {
            return true;
        }
        return false;
    }

    public void cancelLoading() {
        if (viewContent == null || viewAbnormalContainer == null) {
            return;
        }
        viewAbnormalContainer.removeAllViews();
        viewAbnormalContainer.setVisibility(View.GONE);
        if (mViewLoading != null) {
            mViewLoading.onStop();
            mViewLoading = null;
        }
        if (!isInitLoading) {
            cancelLoadingInit();
        } else {
            viewContent.setVisibility(View.VISIBLE);
        }
        isInitLoading = false;
    }

    public void showContent() {
        cancelLoading();
        removeAbnormal();
        if (viewContent != null) {
            viewContent.setVisibility(View.VISIBLE);
        }
    }

    public void showEmpty() {
        showAbnormal(null, "没有内容", null, null);
    }

    public void showRetry() {
        showAbnormal(null, null, "重试", new View.OnClickListener() {
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
        if (viewAbnormalContainer == null) {
            return;
        }
        viewAbnormalContainer.setVisibility(View.VISIBLE);
        if (viewContent != null) {
            viewContent.setVisibility(View.GONE);
        }
        mViewAbnormal = LayoutInflater.from(mContext).inflate(com.knifestone.hyena.R.layout.view_abnormal, null);
        viewAbnormalContainer.addView(mViewAbnormal);

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

    protected void removeAbnormal() {
        if (viewAbnormalContainer != null) {
            viewAbnormalContainer.removeAllViews();
            viewAbnormalContainer.setVisibility(View.GONE);
            mViewAbnormal = null;
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

    //创建loading视图
    protected abstract void createLoadingView();

    //事件传递下去取消请求
    protected abstract void onCancelCall();

    //取消初始化
    protected abstract void cancelLoadingInit();


}
