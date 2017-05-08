###### [EyesEditText.md][file] | [介绍文章][blog]

###### 开袋即食

```
<com.knifestone.hyena.view.edittext.EyesEditText
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:inputType="textPassword"
    android:text="默认的" />
```

###### 自定义属性
```
<!-- 带眼睛的输入框 -->
<declare-styleable name="EyesEditTextStyle">
    <!-- 明文图标 -->
    <attr name="drawable_visibility" format="reference" />
    <!-- 密文图标 -->
    <attr name="drawable_visibility_off" format="reference" />
    <attr name="drawable_tint" />
    <attr name="drawable_follow_focus" />
</declare-styleable>

<!-- icon着色 -->
<attr name="drawable_tint" format="color" />
<!-- 跟随焦点 -->
<attr name="drawable_follow_focus" format="boolean" />
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/edittext/EyesEditText.java
[blog]: http://www.jianshu.com/p/cc0d0ff63ae1

