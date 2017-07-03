package com.knifestone.hyena.holder;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.knifestone.hyena.R;

/**
 * 页面去哪持有者
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-3.
 * 可以根据自己的需求写一个异常页面文件 view_abnormal.xml
 * 可以根据自己的需求传入Loading View
 */
public class WhereToGoViewHolder {

    //父容器
    private FrameLayout mContainer;
    //替换页面
    private View mViewAbnormal;
    //加载页面
    private ViewLoading mViewLoading;

    //创造
    public void create(FrameLayout container, ViewLoading viewLoading) {
        mContainer = container;
        mViewLoading = viewLoading;
    }

    //分离
    public void detace() {
        mContainer = null;
        mViewAbnormal = null;
    }

    /**
     * 显示正常页面
     */
    public void showNormal() {
        if (mContainer == null) {
            return;
        }
        //移除异常页面
        if (mViewAbnormal != null) {
            mContainer.removeView(mViewAbnormal);
            mViewAbnormal = null;
        }
        if (mViewLoading != null) {
            mViewLoading.onStop();
            mContainer.removeView(mViewLoading);
            mViewLoading = null;
        }
    }

    /**
     * 显示loading
     */
    public void showLoading() {
        if (mViewLoading != null) {
            mContainer.addView(mViewLoading);
            mViewLoading.onStart();
        }
    }

    /**
     * 显示去哪
     *
     * @param resImgId 提示图片
     * @param resStrId 提示文字
     * @param resbtnId 按钮文字
     * @param listener 按钮监听
     */
    public void showAbnormal(@DrawableRes Integer resImgId, @StringRes Integer resStrId, @StringRes Integer resbtnId, View.OnClickListener listener) {
        if (mContainer == null) {
            return;
        }
        if (mViewAbnormal == null) {
            mViewAbnormal = LayoutInflater.from(mContainer.getContext()).inflate(R.layout.view_abnormal, null);
            mContainer.addView(mViewAbnormal);
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

}
