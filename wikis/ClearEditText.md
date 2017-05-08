###### [ClearEditText.md][file] | [介绍文章][blog]

###### 开袋即食

```
<com.knifestone.hyena.view.edittext.ClearEditText
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="默认的" />
```

###### 自定义属性
```
<!-- 带清除的输入框 -->
<declare-styleable name="ClearEditTextStyle">
    <!-- 图标 -->
    <attr name="drawable_clear" format="reference" />
    <attr name="drawable_tint" />
    <attr name="drawable_follow_focus" />
</declare-styleable>

<!-- icon着色 -->
<attr name="drawable_tint" format="color" />
<!-- 跟随焦点 -->
<attr name="drawable_follow_focus" format="boolean" />
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/edittext/ClearEditText.java
[blog]:http://www.jianshu.com/u/6e6858f18e58

