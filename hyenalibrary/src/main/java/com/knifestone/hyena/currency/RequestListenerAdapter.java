package com.knifestone.hyena.currency;


/**
 * 简介:回调监听适配器
 * 描述:这个....
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/2/21.
 */
public class RequestListenerAdapter<T> implements RequestListener<T>{

    @Override
    public void onSuccess(T object) {

    }

    @Override
    public void onFailure(int code, String message) {

    }

    @Override
    public void onCompleted() {

    }
}
