package com.knifestone.hyena.currency;


/**
 * 简介:作者有点懒
 * 描述:这个....
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/2/21.
 */
public interface CallBackAdapter<T>{

    void onSuccess(T object);

    void onFailure(String message);

    void onCompleted();
}
