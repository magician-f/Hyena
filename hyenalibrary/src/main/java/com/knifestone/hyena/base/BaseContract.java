package com.knifestone.hyena.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * 简介：契约类
 * 好处：是方便接口统一管理、修改，同时，内容清晰，一目了然。
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/15.
 */
public interface BaseContract {

    interface View {
        Activity getActivity();
        Context getContext();
        void startActivity(Intent intent);
    }

    class Presenter<V extends View> {

        protected V mView;

        public void init(Object view) {
            this.mView = (V) view;
        }

        public void detachView() {
            mView = null;
        }

    }

}
