package com.knifestone.hyena.currency;


/**
 * 简介:请求监听
 * 描述:这个....
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/2/21.
 */
public interface RequestListener<T>{

    void onSuccess(T object);

    void onFailure(int code, String message);

    void onCompleted();
}
