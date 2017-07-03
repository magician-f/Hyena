package com.knifestone.hyena.base;


import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.knifestone.hyena.R;
import com.knifestone.hyena.holder.ViewLoading;

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

    /**
     * 显示正常页面
     */
    public void showNormal() {
        if (viewContent == null) {
            return;
        }
        //移除异常页面
        if (mViewAbnormal != null) {
            viewContent.removeView(mViewAbnormal);
            mViewAbnormal = null;
        }
        if (mViewLoading != null) {
            mViewLoading.onStop();
            viewContent.removeView(mViewLoading);
            mViewLoading = null;
        }
    }

    /**
     * 显示loading
     */
    public void showLoading() {
        if (mViewLoading == null) {
            createLoadingView();
        }
        if (mViewLoading != null) {
            viewContent.addView(mViewLoading);
            mViewLoading.onStart();
        }
    }

    /**
     * 显示异常
     *
     * @param resImgId 提示图片
     * @param resStrId 提示文字
     * @param resbtnId 按钮文字
     * @param listener 按钮监听
     */
    protected void showAbnormal(@DrawableRes Integer resImgId, @StringRes Integer resStrId, @StringRes Integer resbtnId, View.OnClickListener listener) {
        if (mViewAbnormal == null) {
            mViewAbnormal = LayoutInflater.from(mContext).inflate(R.layout.view_abnormal, null);
            viewContent.addView(mViewAbnormal);
        }
        ImageView ivViewEmpty = (ImageView) mViewAbnormal.findViewById(R.id.abnormalIv);
        if (resImgId == null) {
            ivViewEmpty.setVisibility(View.GONE);
        } else {
            ivViewEmpty.setVisibility(View.VISIBLE);
            ivViewEmpty.setImageResource(resImgId);
        }
        TextView tvViewEmpty = (TextView) mViewAbnormal.findViewById(R.id.abnormalTv);
        if (resStrId == null) {
            tvViewEmpty.setVisibility(View.GONE);
        } else {
            tvViewEmpty.setVisibility(View.VISIBLE);
            tvViewEmpty.setText(resStrId);
        }
        Button btnViewEmpty = (Button) mViewAbnormal.findViewById(R.id.abnormalBtn);
        if (listener == null) {
            btnViewEmpty.setVisibility(View.GONE);
            btnViewEmpty.setOnClickListener(null);
        } else {
            btnViewEmpty.setVisibility(View.VISIBLE);
            if (resbtnId != null) {
                btnViewEmpty.setText(resbtnId);
            }
            btnViewEmpty.setOnClickListener(listener);
        }
    }

    @Override
    public void onBackPressed() {
        if (mViewLoading != null) {
            showNormal();
            onCancelCall();
            return;
        }
        super.onBackPressed();
    }

    //创建loading视图
    protected abstract void createLoadingView();

    //事件传递下去取消请求
    protected abstract void onCancelCall();


}
