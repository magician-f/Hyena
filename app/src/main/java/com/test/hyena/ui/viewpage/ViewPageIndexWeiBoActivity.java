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

/**
 * 简介:作者有点懒
 * 描述:这个....
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 *
 * @author 磨刀石
 * @date 2017/12/31
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
        ViewPagerIndicator viewPageIndex;
        ViewPager viewPager;
        String[] str;

        viewPageIndex = findViewById(R.id.viewPageIndex1);
        viewPager = findViewById(R.id.viewPager1);
        str = new String[]{"这是", "默认的", "样式"};
        ViewPagerInit(viewPager, viewPageIndex, str);

        viewPageIndex = findViewById(R.id.viewPageIndex2);
        viewPager = findViewById(R.id.viewPager2);
        str = new String[]{"这是指示器", "超过了屏幕的", "样式","请随意滑动","Hyena","为快速开发而生","做个简单好用的开源库"};
        ViewPagerInit(viewPager, viewPageIndex, str);

        viewPageIndex = findViewById(R.id.viewPageIndex3);
        viewPager = findViewById(R.id.viewPager3);
        str = new String[]{"设置了","丰富的","指示器","属性"};
        ViewPagerInit(viewPager, viewPageIndex, str);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    private void ViewPagerInit(ViewPager viewPager, ViewPagerIndicator viewPagerIndicator, final String[] str) {
        viewPagerIndicator.newData(str)
                .setViewPager(viewPager);
        final ArrayList<TextView> list = new ArrayList<>();
        TextView tv;
        for (int i = 0; i < str.length; i++) {
            tv = new TextView(mContext);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
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
