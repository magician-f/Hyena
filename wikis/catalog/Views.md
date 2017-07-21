## 常用View

* ###### 菜单选项View   |   [MenuItemView.md][MenuItemView.md]

![MenuItemView.png][MenuItemView.png]

* ###### 简单选择器   |   [EasyPickerView.md][EasyPickerView.md]

![EasyPickerView.png][EasyPickerView.png]

* ###### 带眼睛的输入框 | [EyesEditText.md][EyesEditText.md]

属性 | 类型 | 默认值 | 说明
:- | :-- | :--- | :----
drawable_tint           | color         | R.drawable.design_ic_visibility       | icon着色
drawable_follow_focus   | boolean       | true                                  | 跟随焦点
drawable_visibility     | ResourceId    | R.drawable.design_ic_visibility       | 密文图标
drawable_visibility_off | ResourceId    | R.drawable.design_ic_visibility_off   | 密文图标

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

[MenuItemView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/view/MenuItemView.md
[EasyPickerView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/view/EasyPickerView.md
[EyesEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/view/EyesEditText.md
[ClearEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/view/ClearEditText.md
[MarqueeTextView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/view/MarqueeTextView.md
[CountDownButton.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/view/CountDownButton.md

[MenuItemView.png]:https://github.com/KnifeStone/Hyena/blob/master/files/images/MenuItemView.png
[EasyPickerView.png]:https://github.com/KnifeStone/Hyena/blob/master/files/images/EasyPickerView.png





