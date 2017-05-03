# Hyena 鬣狗快速开发库 [更新日志][UpdateLog.md]

![Hyena][Hyena.jpg]
<br/> Start Hyena 加入QQ交流群479585883
## TODO

```
以快速开发为基础核心，整合：
A、常用的自定义View
B、Base类
C、耦合性低的功能实现
D、词典
```

### 使用

#### Step 1. 添加jitpack库到你的构建文件

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

#### Step 2. 添加依赖关系

```
dependencies {
        compile 'com.android.support:appcompat-v7:25.3.0'
        compile 'com.github.KnifeStone:Hyena:v0.3.0'
}
```

# API

## A、自定义View

* ### 带清除的输入框→[ClearEditText.java][ClearEditText.java]

```
<!-- 直接尝用即可 drawable_close不设置会有个默认黑色的图标 -->
<com.knifestone.hyena.view.edittext.ClearEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:drawable_close="@drawable/..." />
```

* ### 倒计时按钮→[CountDownButton.java][CountDownButton.java]→[使用说明][使用说明]

```
onStart()           :开始倒计时（默认总时长60s、默认计时间隔1s
onStart(long)       :开始倒计时（自定义总时长、默认计时间隔
onStart(long,long)  :开始倒计时（自定义总时长、自定义计时间隔
onStop()            :结束倒计时
isCountDown()       :是否在倒计时中
```

* ### 横向跑马灯控件→[HScrollTextView.java][HScrollTextView.java]

```
<!-- 直接尝用即可 -->
<com.knifestone.hyena.view.textview.HScrollTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```
[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md
[ClearEditText.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/edittext/ClearEditText.java
[CountDownButton.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/button/CountDownButton.java
[HScrollTextView.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/textview/HScrollTextView.java

[使用说明]:http://www.jianshu.com/p/27e627c8521f
