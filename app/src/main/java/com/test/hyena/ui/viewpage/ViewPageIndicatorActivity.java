package com.test.hyena.ui.viewpage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.knifestone.hyena.indicator.HyenaIndicatorBlockFlexible;
import com.knifestone.hyena.indicator.HyenaIndicatorBlockSimple;
import com.knifestone.hyena.indicator.HyenaIndicatorBlockTriangle;
import com.knifestone.hyena.indicator.HyenaViewPagerIndicator;
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
public class ViewPageIndicatorActivity extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_view_page_indicator;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        HyenaViewPagerIndicator indicator;
        HyenaIndicatorBlockFlexible block;
        ViewPager viewPager;
        String[] str;

        indicator = findViewById(R.id.viewPageIndex1);
        viewPager = findViewById(R.id.viewPager1);
        str = new String[]{"没有", "滑动块的", "样式"};

        ViewPagerInit(viewPager, indicator, str);

        indicator = findViewById(R.id.viewPageIndex2);
        viewPager = findViewById(R.id.viewPager2);
        str = new String[]{"均分的", "滑动块", "的样式"};
        ViewPagerInit(viewPager, indicator, str);
        HyenaIndicatorBlockSimple blocks = new HyenaIndicatorBlockSimple.Builder(mContext)
                .setHeight(ConvertUtils.dp2px(2))
                .builder();
        indicator.setBlock(blocks);

        indicator = findViewById(R.id.viewPageIndex3);
        viewPager = findViewById(R.id.viewPager3);
        str = new String[]{"局中的", "滑动块", "的样式"};
        ViewPagerInit(viewPager, indicator, str);

        block = new HyenaIndicatorBlockFlexible.Builder(mContext)
                .setHeight(ConvertUtils.dp2px(2))
                .builder();
        indicator.setBlock(block);

        indicator = findViewById(R.id.viewPageIndex4);
        viewPager = findViewById(R.id.viewPager4);
        str = new String[]{"这是灵活的", "滑动块", "并且", "指示器", "超过了屏幕的", "请随意滑动", "Hyena", "为快速开发而生", "做个简单好用的开源库"};
        ViewPagerInit(viewPager, indicator, str);
        block = new HyenaIndicatorBlockFlexible.Builder(mContext)
                .setColor(Color.RED)
                .setColorEnd(Color.GREEN)
                .setHeight(ConvertUtils.dp2px(6))
                .setRoundBead(ConvertUtils.dp2px(4))
                .setMargin(ConvertUtils.dp2px(12), 0, ConvertUtils.dp2px(12), ConvertUtils.dp2px(2))
                .builder();
        indicator.setBlock(block);

        indicator = findViewById(R.id.viewPageIndex5);
        viewPager = findViewById(R.id.viewPager5);
        str = new String[]{"三角形", "滑动块"};
        ViewPagerInit(viewPager, indicator, str);
        HyenaIndicatorBlockTriangle block2 = new HyenaIndicatorBlockTriangle.Builder(mContext)
                .setColor(Color.RED)
                .setHeight(ConvertUtils.dp2px(8))
                .setWidth(ConvertUtils.dp2px(16))
                .builder();
        indicator.setBlock(block2);
    }

    @Override
    public void doBusiness() {


    }

    @Override
    public void onWidgetClick(View view) {

    }

    private void ViewPagerInit(ViewPager viewPager, HyenaViewPagerIndicator indicator, final String[] str) {
        indicator.setViewPager(viewPager);
        indicator.setTitles(str);
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
