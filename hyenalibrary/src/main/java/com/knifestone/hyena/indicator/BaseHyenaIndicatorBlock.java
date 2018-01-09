package com.knifestone.hyena.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckedTextView;

import java.util.ArrayList;


/**
 * 简介:指示器块
 * GitHub https://github.com/KnifeStone.Hyena
 * 邮箱 378741819@qq.com
 *
 * @author KnifeStone
 * @date 2018/01/06
 */
public class BaseHyenaIndicatorBlock extends View implements ViewPager.OnPageChangeListener {

    protected ArrayList<CheckedTextView> textViews;
    protected int itemMargin = 0;

    public BaseHyenaIndicatorBlock(Context context) {
        this(context, null);
    }

    public BaseHyenaIndicatorBlock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseHyenaIndicatorBlock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bindingViewPager(ViewPager viewPager, ArrayList<CheckedTextView> textViews, int itemMargin) {
        viewPager.addOnPageChangeListener(this);
        this.textViews = textViews;
        this.itemMargin = itemMargin;
    }

    /**
     * @param position             当前的位置
     * @param positionOffset       当前滚动比例（左－右／0-1）（右－左／1-0）
     * @param positionOffsetPixels 当前实际滚动的像素（左－右／0-页宽） （右－左／页宽－0）
     *                             被调用的场景： ViewPager滚动时总被回调，这个函数在操作ViewPager时被回调很多次。
     *                             1.手指拖动 action_move 。n次
     *                             2.惯性还原 computeScroll()。n次
     *                             使用场景：做view的动画效果时可以用这个回调函数。
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * @param position 当前的位置
     *                 被调用的场景：ViewPager确定页面是哪一页时。1次
     *                 1. 手指拖动后抬起 action_up 。1次
     *                 2. 或者手指滑动超出屏幕时 action_cancel。1次
     *                 使用场景：页面切换后改变对应的tab的状态可以用这个回调函数
     */
    @Override
    public void onPageSelected(int position) {

    }

    /**
     * @param state 停止、拖动、归位
     *              被调用的场景：ViewPager状态切换时被调用。这个函数在操作ViewPager时被回调3次。
     *              1.开始滚动 dragging拖动状态。1次
     *              2.惯性滚动 settling还原状态。1次
     *              3.滚动结束 idle空闲状态。1次
     *              使用场景：做页面状态变化后引起的view特效时可以用这个回调函数
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            //停止
            case ViewPager.SCROLL_STATE_IDLE:
                break;
            //拖动
            case ViewPager.SCROLL_STATE_DRAGGING:

                break;
            //归位
            case ViewPager.SCROLL_STATE_SETTLING:

                break;
            default:

                break;
        }
    }

}
