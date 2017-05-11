###### [HyenaBaseActivity.java][file] | [介绍文章][blog]

```
public class MainActivity extends ToolbarActivity {

    @Override
    protected int bindLayout() {
        return R.layout.activity_base_toolbar;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

}
```
activity_base_toolbar.xml
```
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

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/base/HyenaBaseActivity.java
[blog]:http://www.jianshu.com/u/6e6858f18e58

