package com.test.hyena.ui.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * Scroller:http://blog.csdn.net/vipzjyno1/article/details/24592591
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-12-28.
 */
public class SimpleScrollerView extends RelativeLayout {

    /**
     abortAnimation()    停止动画，滚到最终的x,y位置中止动画
     computeScrollOffset()   当你想要知道新的位置时候，调用该方法。返回true:动画没结束
     extendDuration(int extend)   延长滚动动画的时间。extend表示延迟时间（单位为毫秒）
     fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY)
     在fling（快速滑动，触摸屏幕后快意移动松开）的手势基础上开始滚动，滚动距离取决于fling的初速度。
     forceFinished(boolean finished)   强制终止滚动。
     getCurrVelocity()   返回当前的速度
     getCurrX()    返回当前滚动的X方向的偏移量（距离原点X轴方向）
     getCurrY()   返回当前滚动的Y方向的偏移量（距离原点Y轴方向）
     getDuration()   返回滚动事件的持续时间（毫秒）
     getFinalX()  返回滚动结束的X方向的偏移量（注：只针对fling 手势有效）（距离原点X轴方向）
     getFinalY()   返回滚动结束的Y方向的偏移量（注：只针对fling 手势有效）（距离原点Y轴方向）
     getStartX()   返回滚动起始点的X方向偏移量（距离原点X轴方向）
     getStartY()  返回滚动起始点的Y方向偏移量.（距离原点Y轴方向）
     isFinished()   返回scroller滚动是否结束，true:滚动结束    false:还在滚动
     setFinalX(int newX)  设置scroller的终止时X方向偏移量
     setFinalY(int newY)   设置scroller的终止时Y方向偏移量
     setFriction(float friction)
     The amount of friction applied to flings.
     startScroll(int startX, int startY, int dx, int dy)
     提供起始点和滚动距离，调用该方法进行滚动。（此处默认时间为250ms）
     startScroll(int startX, int startY, int dx, int dy, int duration)
     提供起始点和滚动距离以及滚动时间，调用该方法进行滚动。
     timePassed()  返回自滚动开始经过的时间（毫秒）
     */
    private Scroller scroller;

    /**
     * 只能通过xml使用
     */
    public SimpleScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**
         *
         AccelerateDecelerateInterpolator     动画效果：开始和结束都是缓慢的，通过中间时候加速
         AccelerateInterpolator,      动画效果：开始缓慢，之后加速
         AnticipateInterpolator,       动画效果：开始后退，然后前进
         AnticipateOvershootInterpolator,   动画效果：开始后退，之后前进并超过终点位置，最终退回到终点
         BounceInterpolator,        动画效果：慢慢反弹到，弹性衰减到结束
         CycleInterpolator,          动画效果：重复循环动画，速度变化遵循正弦定律
         DecelerateInterpolator,        动画效果：刚开始快速，之后减速
         LinearInterpolator,         动画效果：不断的变化
         OvershootInterpolator         动画效果：像前超越最终点然后回来
         */
        scroller = new Scroller(context,new DecelerateInterpolator(),false);
    }

    public void startScroll(int x, int y) {
        scroller.startScroll(getScrollX(), getScrollY(), x, y,600);
        invalidate();
    }

    @Override
    public void computeScroll() {
        //判断滚动是否完成
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        }
    }
}
