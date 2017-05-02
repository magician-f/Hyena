# Hyena 鬣狗快速开发库 [更新日志][UpdateLog.md]

## 怎么使用

### Step 1. 添加jitpack库到你的构建文件

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2. 添加依赖关系

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
onStart(long,long)  :开始倒计时（自定义总时长、默认计时间隔
onStop()            :结束倒计时
isCountDown()       :是否在倒计时中
```

* ### HScrollTextView 横向跑马灯→[HScrollTextView.java][HScrollTextView.java]
```
直接在需要的使用的时候把它当作一个TextView来使用即可
```



[CountDownButton.java]: https://github.com/zapailaohei/Hyena/blob/master/hyenalibrary/src/main/java/com/akita/hyena/view/button/CountDownButton.java
[HScrollTextView.java]: https://github.com/zapailaohei/Hyena/blob/master/hyenalibrary/src/main/java/com/akita/hyena/view/textview/HScrollTextView.java

