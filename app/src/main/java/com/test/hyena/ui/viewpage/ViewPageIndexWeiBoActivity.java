package com.test.hyena.ui.viewpage;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

/**
 * 简介:作者有点懒
 * 描述:这个....
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by 磨刀石 on 2017/12/31.
 */
public class ViewPageIndexWeiBoActivity extends BaseActivity {

    private ViewPageIndexWeiBo viewPageIndex;
    private ViewPager viewPager;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_view_page_index_weibo;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        viewPageIndex = findViewById(R.id.viewPageIndex);
        viewPager = findViewById(R.id.viewPager);
        viewPageIndex.initData(new String[]{"关注", "推荐", "视频", "直播", "图片", "段子", "精华", "热门"}, viewPager, 0);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

}
