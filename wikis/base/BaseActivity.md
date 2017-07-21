* ###### 继承HyenaBaseActivity

```
public class TestActivity extends HyenaBaseActivity {

    /**
     * 调用顺序
     * onCreate() > setContentView() > initView() > getData()
     */

    @Override
    protected void setContentView() {
        //setContentView(id);
        //setContentView(view);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

    }
}
```

* ###### 继承HyenaToolbarActivity 懒实现加载Toolbar

```
public class TestActivity extends HyenaToolbarActivity {

    /**
     * 调用顺序
     * onCreate() > bindLayout() > getContentLayout() > initView() > getData()
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
}
```

```
activity_base_toolbar.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:background="@android:color/white"
    android:orientation="vertical">

    <android.support.v7.widget.Toolbar
        android:id="@id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
        app:navigationIcon="@drawable/ic_arrow_back_white_24dp"
        android:background="@android:color/black">

        <TextView
            android:id="@+id/tvTitle"
            style="@style/TextAppearance.AppCompat.Widget.ActionBar.Title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"/>
    </android.support.v7.widget.Toolbar>

    <FrameLayout
        android:id="@+id/viewContent"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```

* ###### 继承HyenaWhereGoActivity 懒实现加载Toolbar 并实现loading、异常页面切换

```
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
     * 可以重写view_abnormal.xml 文件名与变量名应相同
     * 也重写showAbnormal(...)
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
```

```
view_abnormal.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/abnormalLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/abnormalBackground"
    android:gravity="center"
    android:orientation="vertical"
    android:paddingBottom="@dimen/abnormalPaddingBottom">

    <ImageView
        android:id="@+id/abnormalIv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/abnormalTv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="@dimen/abnormalTextViewMarginTop"
        android:visibility="gone"
        tools:text="内容"
        tools:visibility="visible" />

    <Button
        android:id="@+id/abnormalBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="@dimen/abnormalButtonMarginTop"
        android:background="@drawable/abnormalButtonBackground"
        android:minHeight="40dp"
        android:paddingBottom="5dp"
        android:paddingLeft="20dp"
        android:paddingRight="20dp"
        android:paddingTop="5dp"
        android:text="重试"
        android:textColor="@color/abnormalButtonTextColor"
        android:textSize="16sp"
        android:visibility="gone"
        tools:visibility="visible" />

</LinearLayout>
```







