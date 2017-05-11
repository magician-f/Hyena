package com.knifestone.hyena.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 简介:
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/3.
 */
public interface HyenaMVPView {

    void init(LayoutInflater inflater, ViewGroup container);
    View getView();
}
