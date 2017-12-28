package com.test.hyena.ui.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * http://blog.csdn.net/guolin_blog/article/details/48719871
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-12-28.
 */
public class ScrollerGroup extends ViewGroup {

    /**
     * 用于完成滚动操作的实例
     */
    private Scroller mScroller;

    /**
     * 判定为拖动的最小移动像素数
     */
    private int mTouchSlop;

    /**
     * 手机按下时的屏幕坐标
     */
    private float mXDown;

    /**
     * 手机当时所处的屏幕坐标
     */
    private float mXMove;

    /**
     * 上次触发ACTION_MOVE事件时的屏幕坐标
     */
    private float lastX;

    /**
     * 界面可滚动的左边界
     */
    private int leftBorder;

    /**
     * 界面可滚动的右边界
     */
    private int rightBorder;

    /**
     * 接收触摸事件后是否 不受父级控制(默认开启)
     */
    private boolean disallowIntercept = true;

    public ScrollerGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 第一步，创建Scroller的实例
        mScroller = new Scroller(context);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        // 获取TouchSlop值
        mTouchSlop = configuration.getScaledPagingTouchSlop();
    }

    /**
     * 自定义Group的逻辑：宽度充满屏幕、里面的子View充满Group并水平排列View
     * 先处理自定Group逻辑，摆放子view 逻辑都写在注释里了
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            // 为ScrollerLayout中的每一个子控件测量大小
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (!changed) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int left = i * childView.getMeasuredWidth();
            int right = (i + 1) * childView.getMeasuredWidth();
            // 为ScrollerLayout中的每一个子控件在水平方向上进行布局
            childView.layout(left, 0, right, childView.getMeasuredHeight());
        }
        // 初始化左右边界值
        leftBorder = getChildAt(0).getLeft();
        rightBorder = getChildAt(getChildCount() - 1).getRight();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mXDown = ev.getRawX();
                lastX = mXDown;
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //一旦底层View收到touch的action后调用这个方法那么父层View就不会再调用onInterceptTouchEvent了，也无法截获以后的action。
        getParent().requestDisallowInterceptTouchEvent(disallowIntercept);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mXMove = event.getRawX();
                //向右滑动时为负数，计算与上次移动距离的差值
                float scrolledX = lastX - mXMove;
                lastX = mXMove;
                //getScrollX()获得X轴滑动距离 向左滑为正 反之为负
                if (getScrollX() + scrolledX < leftBorder) {
                    //当滑动到最左边就不能继续滑动了
                    scrollTo(leftBorder, 0);
                    return true;
                }
                else if (getScrollX() + getWidth() + scrolledX > rightBorder) {
                    //当滑动到最右边就不能继续滑动了
                    scrollTo(rightBorder - getWidth(), 0);
                    return true;
                }
                scrollBy((int) scrolledX, 0);

                float diffX = Math.abs(mXMove - mXDown);
                // 当手指拖动值大于TouchSlop值时，认为应该进行滚动，拦截子控件的事件
                if (diffX > mTouchSlop) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                restore();
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 恢复
     */
    private void restore() {
        // 当手指抬起时，根据当前的滚动值来判定应该滚动到哪个子控件的界面
        int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
        int dx = targetIndex * getWidth() - getScrollX();
        // 第二步，调用startScroll()方法来初始化滚动数据并刷新界面
        mScroller.startScroll(getScrollX(), 0, dx, 0);
        invalidate();
    }

    @Override
    public void computeScroll() {
        // 第三步，重写computeScroll()方法，并在其内部完成平滑滚动的逻辑
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void setDisallowIntercept(boolean disallowIntercept) {
        this.disallowIntercept = disallowIntercept;
    }
}