# Hyena 鬣狗快速开发库 [更新日志][UpdateLog.md]

[![language][languageSvg]]() [![jitPack][jitPackSvg]][jitPack] [![api][apiSvg]][api]
<br/> Start Hyena 加入QQ交流群479585883

## TODO

```
以快速开发为基础核心，整合：
A、常用的自定义View
B、Base类
C、通用
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
    //根据实际引用的版本自行调整版本号
    compile 'com.android.support:appcompat-v7:25.3.0'
    compile 'com.github.KnifeStone:Hyena:v0.4.0'
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

* ### 倒计时按钮 [CountDownButton.java][CountDownButton.java]    [详细说明][CountDownButton.blog]

```
onStart()           :开始倒计时（默认总时长60s、默认计时间隔1s
onStart(long)       :开始倒计时（自定义总时长、默认计时间隔
onStart(long,long)  :开始倒计时（自定义总时长、自定义计时间隔
onStop()            :结束倒计时
isCountDown()       :是否在倒计时中
```

* ### 横向跑马灯控件 [MarqueeTextView.java][MarqueeTextView.java]

```
<!-- 直接尝用即可 -->
<com.knifestone.hyena.view.textview.MarqueeTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="..."/>
```

# C、通用

* ### 防止双击监听 [DoubleClickListener.java][DoubleClickListener.java]

```
static void init(long DelayTime)        :静态方法（配置双击间隔时间
static boolean checkDoubleClick()       :静态方法（手动检测是否双击
abstract void onNoDoubleClick(View v)   :当作View.OnClickListener来使用，替换onClick(View v)
```

[languageSvg]:https://img.shields.io/badge/language-java-blue.svg
[jitPackSvg]:https://jitpack.io/v/KnifeStone/Hyena.svg
[jitPack]:https://jitpack.io/#KnifeStone/Hyena
[apiSvg]: https://img.shields.io/badge/API-15+-blue.svg
[api]: https://android-arsenal.com/api?level=15

[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md
[ClearEditText.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/edittext/ClearEditText.java
[CountDownButton.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/button/CountDownButton.java
[MarqueeTextView.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/textview/MarqueeTextView.java
[DoubleClickListener.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/currency/DoubleClickListener.java


[CountDownButton.blog]:http://www.jianshu.com/p/27e627c8521f
