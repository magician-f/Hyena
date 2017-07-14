package com.test.hyena.ui;

import com.knifestone.hyena.base.activity.HyenaWhereGoActivity;
import com.knifestone.hyena.view.loading.ViewLoading;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-3.
 */
public class TestActivity extends HyenaWhereGoActivity {

    /**
     * 调用顺序
     * onCreate() > bindLayout() > getContentLayout() > initView() > getData()
     *
     * API:
     * 显示loading
     * showLoading()
     * 显示初始化的loading
     * showLoadingInit() （隐藏背景
     * 是否是loading状态
     * isLoading()
     * 取消loading
     * cancelLoading()
     *
     * 可以自定义view_abnormal.xml来定制异常页面
     * 并重写showAbnormal(...)
     *
     * 显示异常
     * showAbnormal(DrawableRes,StringRes,StringRes,View.OnClickListener)
     * 移除异常页面
     * removeAbnormal()
     */

    @Override
    protected int bindLayout() {
        //需要懒实现Toolbar 你也可以自定义过xml文件，文件名与变量名应相同
        //return R.layout.activity_base_toolbar;

        //不需要Toolbar
        return 0;
    }

    @Override
    protected int getContentLayout() {
        //这里返回实际的页面xml
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void createLoadingView() {
        //这里需要自己去实现loading的动画
        mViewLoading = new ViewLoading(mContext) {
            @Override
            public void bingLayout() {
                super.bingLayout();
            }

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onStop() {
                super.onStop();
            }
        };
    }

    @Override
    protected void onCancelCall() {
        //取消loading的回调
    }
}
