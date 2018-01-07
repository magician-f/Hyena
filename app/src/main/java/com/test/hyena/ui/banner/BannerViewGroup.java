package com.test.hyena.ui.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.test.hyena.R;

/**
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2018-1-3.
 */
public class BannerViewGroup extends RelativeLayout {

    private ViewPager viewPager;

    public BannerViewGroup(Context context) {
        this(context, null);
    }

    public BannerViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_banner, this, true);
//        viewPager = findViewById(R.id.viewPager);
    }

    private void initAttr(AttributeSet attrs) {

    }
}
