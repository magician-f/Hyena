package com.knifestone.hyena.currency;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

/**
 * 过时方法适配器
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-9-25.
 */
public class DeprecatedAdapter {

    /**
     * 获得颜色
     *
     * @param context
     * @param color
     * @return
     */
    public static int getColor(Context context, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(color);
        } else {
            return context.getResources().getColor(color);
        }
    }

    /**
     * 获得drawable文件
     *
     * @param context
     * @param id
     * @return
     */
    public static Drawable getDrawable(Context context, @DrawableRes int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getDrawable(id);
        } else {
            return context.getResources().getDrawable(id);
        }
    }
}
