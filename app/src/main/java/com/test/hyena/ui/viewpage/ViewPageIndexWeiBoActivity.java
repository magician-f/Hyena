package com.test.hyena.ui.viewpage;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.hyena.R;
import com.test.hyena.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 简介:作者有点懒
 * 描述:这个....
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by 磨刀石 on 2017/12/31.
 */
public class ViewPageIndexWeiBoActivity extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_view_page_index_weibo;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        init1();
        init2();
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    private void init1(){
        ViewPagerIndex viewPageIndex = findViewById(R.id.viewPageIndex);
        ViewPager viewPager = findViewById(R.id.viewPager);
        final String[] str = new String[]{"关注", "大时代", "天才的饭局", "关注", "大时代", "天才的饭局"};
        viewPageIndex.newData(str)
                .setViewPager(viewPager);
        final List<TextView> list = new ArrayList<>();
        TextView tv;
        for (int i = 0; i < str.length; i++) {
            tv = new TextView(mContext);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16f);
            tv.setGravity(Gravity.CENTER);
            tv.setText(str[i]);
            list.add(tv);
        }
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return str.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                if (object instanceof View) {
                    View scaleView = (View) object;
                    container.removeView(scaleView);
                }
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position));
                return list.get(position);
            }

        });
    }

    private void init2(){
        ViewPagerIndex viewPageIndex = findViewById(R.id.viewPageIndex2);
        ViewPager viewPager = findViewById(R.id.viewPager2);
        final String[] str = new String[]{"关注", "大时代", "饭局",};
        viewPageIndex.newData(str)
                .setViewPager(viewPager);
        final List<TextView> list = new ArrayList<>();
        TextView tv;
        for (int i = 0; i < str.length; i++) {
            tv = new TextView(mContext);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16f);
            tv.setGravity(Gravity.CENTER);
            tv.setText(str[i]);
            list.add(tv);
        }
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return str.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                if (object instanceof View) {
                    View scaleView = (View) object;
                    container.removeView(scaleView);
                }
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position));
                return list.get(position);
            }

        });
    }

}
