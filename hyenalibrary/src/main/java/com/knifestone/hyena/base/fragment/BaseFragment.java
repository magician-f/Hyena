package com.knifestone.hyena.base.fragment;

import android.os.Bundle;


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
public abstract class BaseFragment extends BaseIViewFragment {

    private boolean isInit = false;
    private Bundle savedInstanceState;
    public static final String INTENT_BOOLEAN_LAZYLOAD = "intent_boolean_lazyLoad";
    private boolean isLazyLoad = true;

    protected void onCreateView(Bundle savedInstanceState) {
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
                onCreateView();
            } else {
                //todo
            }
        } else {
            isInit = true;
            onCreateView();
        }

    }

    protected int isVisibleToUserState = VISIBLE_STATE_NOTSET;
    //未设置值
    protected static final int VISIBLE_STATE_NOTSET = -1;
    //可见
    protected static final int VISIBLE_STATE_VISIABLE = 1;
    //不可见
    protected static final int VISIBLE_STATE_GONE = 0;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisibleToUserState = isVisibleToUser ? VISIBLE_STATE_VISIABLE : VISIBLE_STATE_GONE;
        if (isVisibleToUser && !isInit && contentView != null) {
            isInit = true;
            onCreateView();
            onFragmentResume();
        }
        if (isInit && contentView != null) {
            if (isVisibleToUser) {
                isStart = true;
                onFragmentStart();
            } else {
                isStart = false;
                onFragmentStop();
            }
        }
    }

    @Override
    public final void onStart() {
        super.onStart();
        if (isInit && !isStart && getUserVisibleHint()) {
            isStart = true;
            onFragmentStart();
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        if (isInit && isStart && getUserVisibleHint()) {
            isStart = false;
            onFragmentStop();
        }
    }

    private boolean isStart = false;

    protected void onCreateView() {
        initView(savedInstanceState);
        initData(savedInstanceState);
        doBusiness();
    }

    protected void onFragmentStart() {

    }

    protected void onFragmentStop() {

    }

    protected void onFragmentResume() {

    }

    protected void onFragmentPause() {

    }

    protected void onFragmentDestroyView() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (isInit) {
            onFragmentResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isInit) {
            onFragmentPause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (isInit) {
            onFragmentDestroyView();
        }
        isInit = false;
    }
}