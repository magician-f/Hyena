# Hyena 鬣狗快速开发库 [更新日志][UpdateLog.md]

当鬣狗集体捕获猎物时，它们就会一拥而上，同时撕咬猎物的肚子、颈部、四肢及全身各处。为了防备狮子前来掠夺它们的食物，整个族群的斑鬣狗就一起狼吞虎咽地分享这份大餐。鬣狗是效率极高的食肉动物，短短数十分钟内，猎物便只剩下骨头。

## 使用

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
        compile 'com.github.zapailaohei:Hyena:v0.2.0'
}
```

## API

* ### CountDownButton 倒计时按钮→[CountDownButton.java][CountDownButton.java]

```
onStart()           :开始倒计时（默认总时长60s、默认计时间隔1s
onStart(long)       :开始倒计时（自定义总时长、默认计时间隔
onStart(long,long)  :开始倒计时（自定义总时长、自定义计时间隔
onStop()            :结束倒计时
isCountDown()       :是否在倒计时中
```

* ### HScrollTextView 横向跑马灯控件→[HScrollTextView.java][HScrollTextView.java]

```
<-- 直接尝用即可 -->
<com.akita.hyena.view.textview.HScrollTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```





[UpdateLog.md]: https://github.com/zapailaohei/Hyena/blob/master/UpdateLog.md
[CountDownButton.java]: https://github.com/zapailaohei/Hyena/blob/master/hyenalibrary/src/main/java/com/akita/hyena/view/button/CountDownButton.java
[HScrollTextView.java]: https://github.com/zapailaohei/Hyena/blob/master/hyenalibrary/src/main/java/com/akita/hyena/view/textview/HScrollTextView.java

