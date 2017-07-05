## 常用View

* ###### 菜单选项View   |   [MenuItemView.md][MenuItemView.md]

![MenuItemView.png][MenuItemView.png]

* ###### 简单选择器   |   [EasyPickerView.md][EasyPickerView.md]

![EasyPickerView.png][EasyPickerView.png]

* ###### 带眼睛的输入框 | [EyesEditText.md][EyesEditText.md]

```
app:drawable_tint="@color/..."                  | icon着色
app:drawable_follow_focus="true|false"          | 跟随焦点
app:drawable_visibility="@drawable/..."         | 明文图标
app:drawable_visibility_off="@drawable/..."     | 密文图标
```

* ###### 带清除的输入框 | [ClearEditText.md][ClearEditText.md]

```
app:drawable_tint="@color/..."                  | icon着色
app:drawable_follow_focus="true|false"          | 跟随焦点
app:drawable_clear="@drawable/..."              | 图标
```

* ###### 倒计时按钮 | [CountDownButton.md][CountDownButton.md]

```
onStart()           | 开始倒计时（默认总时长60s、默认计时间隔1s
onStart(long)       | 开始倒计时（自定义总时长、默认计时间隔
onStart(long,long)  | 开始倒计时（自定义总时长、自定义计时间隔
onStop()            | 结束倒计时
isCountDown()       | 是否在倒计时中
```

* ###### 横向跑马灯控件 | [MarqueeTextView.md][MarqueeTextView.md]

```
//开袋即食
<com.knifestone.hyena.view.textview.MarqueeTextView
    .../>
```

[MenuItemView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/MenuItemView.md
[EasyPickerView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/EasyPickerView.md
[EyesEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/EyesEditText.md
[ClearEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/ClearEditText.md
[MarqueeTextView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/MarqueeTextView.md
[CountDownButton.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/CountDownButton.md

[MenuItemView.png]:https://github.com/KnifeStone/Hyena/blob/master/files/images/MenuItemView.png
[EasyPickerView.png]:https://github.com/KnifeStone/Hyena/blob/master/files/images/EasyPickerView.png





