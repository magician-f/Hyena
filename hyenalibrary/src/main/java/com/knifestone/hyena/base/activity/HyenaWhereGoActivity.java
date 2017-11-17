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
    //中断
    protected boolean isInterrupt;

    /**
     * 显示loading
     */
    public boolean showLoading() {
        if (viewContent == null || viewAbnormalContainer==null) {
            return false;
        }
        if (mViewLoading == null) {
            createLoadingView();
        }
        if (mViewLoading == null) {
            return false;
        }
        if (mViewLoading.getParent() != null) {
            return false;
        }
        viewAbnormalContainer.addView(mViewLoading);
        mViewLoading.onStart();
        return true;
    }

    /**
     * 显示初始化的loading （隐藏背景
     */
    public void showLoadingInit() {
        if (showLoading()) {
            viewContent.setVisibility(View.GONE);
        }
    }

    /**
     * 是否是loading状态
     */
    public boolean isLoading() {
        if (mViewLoading != null) {
            return true;
        }
        return false;
    }

    /**
     * 取消loading
     */
    public void cancelLoading() {
        if (viewContent == null || viewAbnormalContainer == null) {
            return;
        }
        if (mViewLoading != null) {
            mViewLoading.onStop();
            viewAbnormalContainer.removeView(mViewLoading);
            mViewLoading = null;
            if (isInterrupt) {
                cancelInit();
            }else{
                viewContent.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * 初始化加载失败的取消loading
     */
    public void cancelLoadingInitFail(){
        isInterrupt = true;
        cancelLoading();
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
        if (viewAbnormalContainer==null){
            return;
        }
        viewContent.setVisibility(View.GONE);
        if (mViewAbnormal == null) {
            mViewAbnormal = LayoutInflater.from(mContext).inflate(com.knifestone.hyena.R.layout.view_abnormal, null);
            viewAbnormalContainer.addView(mViewAbnormal);
        }
        ImageView ivViewEmpty = (ImageView) mViewAbnormal.findViewById(com.knifestone.hyena.R.id.abnormalIv);
        if (resImgId == null) {
            ivViewEmpty.setVisibility(View.GONE);
        } else {
            ivViewEmpty.setVisibility(View.VISIBLE);
            ivViewEmpty.setImageResource(resImgId);
        }
        TextView tvViewEmpty = (TextView) mViewAbnormal.findViewById(com.knifestone.hyena.R.id.abnormalTv);
        if (resStrId == null) {
            tvViewEmpty.setVisibility(View.GONE);
        } else {
            tvViewEmpty.setVisibility(View.VISIBLE);
            tvViewEmpty.setText(resStrId);
        }
        Button btnViewEmpty = (Button) mViewAbnormal.findViewById(com.knifestone.hyena.R.id.abnormalBtn);
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

    /**
     * 移除异常页面
     */
    public void removeAbnormal() {
        if (viewAbnormalContainer == null) {
            return;
        }
        //移除异常页面
        if (mViewAbnormal != null) {
            viewContent.setVisibility(View.VISIBLE);
            viewAbnormalContainer.removeView(mViewAbnormal);
            mViewAbnormal = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (isLoading()) {
            cancelLoadingInitFail();
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
    protected abstract void cancelInit();


}
