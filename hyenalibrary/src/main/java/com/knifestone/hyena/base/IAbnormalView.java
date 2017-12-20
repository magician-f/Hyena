package com.knifestone.hyena.base;

import android.view.View;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-12-20.
 */
public interface IAbnormalView {

    /**
     * 显示内容
     */
    void showContent();
    /**
     * 显示loading
     */
    void showLoadingInit();

    /**
     * 显示空布局
     */
    void showEmpty();

    /**
     * 显示重试
     */
    void showError();

    void showAbnormal(View view);

    /**
     * 取消异常
     */
    void cancelAbnormal();

}
