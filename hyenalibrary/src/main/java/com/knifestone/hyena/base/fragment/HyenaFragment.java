package com.knifestone.hyena.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * <h1>懒加载Fragment</h1> 只有创建并显示的时候才会调用onCreateViewLazy方法<br>
 * <br>
 * <p>
 * 懒加载的原理onCreateView的时候Fragment有可能没有显示出来。<br>
 * 但是调用到setUserVisibleHint(boolean isVisibleToUser),isVisibleToUser =
 * true的时候就说明有显示出来<br>
 * 但是要考虑onCreateView和setUserVisibleHint的先后问题所以才有了下面的代码
 * <p>
 * 注意：<br>
 * 《1》原先的Fragment的回调方法名字后面要加个Lazy，比如Fragment的onCreateView方法， 就写成onCreateViewLazy <br>
 * 《2》使用该LazyFragment会导致多一层布局深度
 * <p>
 * LuckyJayce
 */
public abstract class HyenaFragment extends HyenaBaseFragment {
    private boolean isInit = false;
    private Bundle savedInstanceState;
    public static final String INTENT_BOOLEAN_LAZYLOAD = "intent_boolean_lazyLoad";
    private boolean isLazyLoad = true;

    @Deprecated
    protected final void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        Bundle bundle = getArguments();
        if (bundle != null) {
            isLazyLoad = bundle.getBoolean(INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        }
        //为什么不直接getUserVisibleHint();而是通过自己存isVisibleToUserState变量判断
        //因为v4的25的版本 已经调用 setUserVisibleHint(true)，结果到这里getUserVisibleHint是false
        // （ps:看了FragmentManager源码Fragment被重新创建有直接赋值isVisibleToUser不知道是不是那里和之前v4有改动的地方）
        //所以我默认VISIBLE_STATE_NOTSET，之前没有调用setUserVisibleHint方法，就用系统的getUserVisibleHint，否则就用setUserVisibleHint后保存的值
        //总之就是调用了setUserVisibleHint 就使用setUserVisibleHint的值
        boolean isVisibleToUser;
        if (isVisibleToUserState == VISIBLE_STATE_NOTSET) {
            isVisibleToUser = getUserVisibleHint();
        } else {
            isVisibleToUser = isVisibleToUserState == VISIBLE_STATE_VISIABLE;
        }
        if (isLazyLoad) {
            if (isVisibleToUser && !isInit) {
                isInit = true;
                onCreateViewLazy(savedInstanceState);
            } else {
                //todo
            }
        } else {
            isInit = true;
            onCreateViewLazy(savedInstanceState);
        }
    }

    private int isVisibleToUserState = VISIBLE_STATE_NOTSET;
    //未设置值
    private static final int VISIBLE_STATE_NOTSET = -1;
    //可见
    private static final int VISIBLE_STATE_VISIABLE = 1;
    //不可见
    private static final int VISIBLE_STATE_GONE = 0;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisibleToUserState = isVisibleToUser ? VISIBLE_STATE_VISIABLE : VISIBLE_STATE_GONE;
        if (isVisibleToUser && !isInit && getContentView() != null) {
            isInit = true;
            onCreateViewLazy(savedInstanceState);
            onResumeLazy();
        }
        if (isInit && getContentView() != null) {
            if (isVisibleToUser) {
                isStart = true;
                onFragmentStartLazy();
            } else {
                isStart = false;
                onFragmentStopLazy();
            }
        }
    }

    @Deprecated
    @Override
    public final void onStart() {
        super.onStart();
        if (isInit && !isStart && getUserVisibleHint()) {
            isStart = true;
            onFragmentStartLazy();
        }
    }

    @Deprecated
    @Override
    public final void onStop() {
        super.onStop();
        if (isInit && isStart && getUserVisibleHint()) {
            isStart = false;
            onFragmentStopLazy();
        }
    }

    private boolean isStart = false;

    protected void onFragmentStartLazy() {

    }

    protected void onFragmentStopLazy() {

    }

    protected void onCreateViewLazy(Bundle savedInstanceState) {

    }

    protected void onResumeLazy() {

    }

    protected void onPauseLazy() {

    }

    protected void onDestroyViewLazy() {

    }

    public void setContentView(int layoutResID) {
        viewContent.removeAllViews();
        View view = LayoutInflater.from(mContext).inflate(layoutResID, viewContent, false);
        viewContent.addView(view);
    }

    public void setContentView(View view) {
        viewContent.removeAllViews();
        viewContent.addView(view);
    }

    @Override
    @Deprecated
    public final void onResume() {
        super.onResume();
        if (isInit) {
            onResumeLazy();
        }
    }

    @Override
    @Deprecated
    public final void onPause() {
        super.onPause();
        if (isInit) {
            onPauseLazy();
        }
    }

    @Override
    @Deprecated
    public final void onDestroyView() {
        super.onDestroyView();
        if (isInit) {
            onDestroyViewLazy();
        }
        isInit = false;
    }
}