###### [EasyPickerView.java][file] | [介绍文章][blog]

###### [转载自huzenan](https://github.com/huzenan/EasyPickerView)

###### 可以设置的属性

```
<declare-styleable name="EasyPickerView">
    <attr name="epvTextSize" format="dimension"/>
    <attr name="epvTextColor" format="color"/>
    <attr name="epvTextPadding" format="dimension"/>
    <attr name="epvTextMaxScale" format="float"/>
    <attr name="epvTextMinAlpha" format="float"/>
    <attr name="epvRecycleMode" format="boolean"/>
    <attr name="epvMaxShowNum" format="integer"/>
</declare-styleable>
```

###### layout

```
<com.knifestone.hyena.view.picker.EasyPickerView
        android:id="@+id/cpv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:paddingLeft="15dp"
        android:paddingRight="15dp"
        item:epvRecycleMode="true"
        item:epvTextColor="#4aa4a4"
        item:epvTextMaxScale="2.0"
        item:epvTextMinAlpha="0.35"
        item:epvTextPadding="10dp"
        item:epvTextSize="30sp"/>
```

###### activity

```
cpv.setDataList(dataList);
cpv.setOnScrollChangedListener(new EasyPickerView.OnScrollChangedListener() {
    @Override
    public void onScrollChanged(int curIndex) {
        // your codes.
    }

    @Override
    public void onScrollFinished(int curIndex) {
        // your codes.
    }
});
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/picker/EasyPickerView.java
[blog]: http://www.jianshu.com/u/6e6858f18e58

