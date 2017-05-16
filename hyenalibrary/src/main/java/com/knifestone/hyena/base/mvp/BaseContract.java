package com.knifestone.hyena.base.mvp;

import android.app.Activity;

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
    }

    interface Model {

    }

    class Presenter<M extends Model, V extends View> {

        protected M mModel;
        protected V mView;

        public void init(Object view, Object model) {
            this.mView = (V) view;
            this.mModel = (M) model;
        }

        public void detachView() {
            mView = null;
            mModel = null;
        }

    }

}
