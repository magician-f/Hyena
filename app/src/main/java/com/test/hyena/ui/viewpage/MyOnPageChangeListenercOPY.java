package com.test.hyena.ui.viewpage;

import android.content.Context;
import android.support.v4.view.ViewPager;


public class MyOnPageChangeListenercOPY implements ViewPager.OnPageChangeListener {

    private ViewPagerIndex viewPagerTitle;
    private ViewPager pager;
    private int[] location = new int[2];

    public MyOnPageChangeListenercOPY(Context context, ViewPager viewPager, ViewPagerIndex viewPagerTitle) {
        this.viewPagerTitle = viewPagerTitle;
        this.pager = viewPager;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {
//        viewPagerTitle.setCurrentItem(position);
    }


    @Override
    public void onPageScrollStateChanged(int state) {
        boolean scrollRight;//页面向右
//        if (state == SCROLL_STATE_SETTLING) {
//            scrollRight = lastPosition < pager.getCurrentItem();
//            lastPosition = pager.getCurrentItem();
//            if (lastPosition + 1 < textViews.size() && lastPosition - 1 >= 0) {
//                textViews.get(scrollRight ? lastPosition + 1 : lastPosition - 1).getLocationOnScreen(location);
//                if (location[0] > screenWidth) {
//                    viewPagerTitle.smoothScrollBy(screenWidth / 2, 0);
//                } else if (location[0] < 0) {
//                    viewPagerTitle.smoothScrollBy(-screenWidth / 2, 0);
//                }
//            }
//        }
    }

}
