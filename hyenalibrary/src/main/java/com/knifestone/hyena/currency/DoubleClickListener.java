package com.knifestone.hyena.currency;

import android.view.View;

/**
 * 简介:防止双击监听
 * GitHub https://github.com/zapailaohei
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public abstract class DoubleClickListener implements View.OnClickListener {

    /**
     * 双击判定 延迟时间
     */
    private static long MIN_CLICK_DELAY_TIME = 400;

    /**
     * 记录最近一次点击的时间
     */
    private static long lastClickTime = 0;

    /**
     * 配置
     *
     * @param DelayTime 间隔时间
     */
    public static void init(long DelayTime) {
        if (DelayTime > 0) {
            MIN_CLICK_DELAY_TIME = DelayTime;
        }
    }

    /**
     * 判断是否双击
     */
    public static boolean checkDoubleClick() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    public abstract void onNoDoubleClick(View v);


}
