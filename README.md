# "高效、精准，鬣狗为快速开发而生。"

[![language][languageSvg]]() [![jitPack][jitPackSvg]][jitPack] [![api][apiSvg]][api]

###### Start Hyena 加入QQ交流群479585883

## 说明 | [更新日志][UpdateLog.md] | [demo.apk][蒲公英下载地址]

[Hyena鬣狗快速开发库][Hyena]核心为`快速开发`，定位`小巧精悍`，内容`简单精致`，整合`常用View`、`推荐类库`、`通用`、`词典`、`Base类`


## 如何使用

###### Step 1. 添加jitpack库到你的构建文件

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

###### Step 2. 添加依赖关系

```
dependencies {
    //根据实际引用的版本自行调整版本号
    compile 'com.android.support:appcompat-v7:25.3.1'
    compile 'com.github.KnifeStone:Hyena:1.1.0'
}
```

## 常用View

* ###### 菜单选项View   |   [MenuItemView.md][MenuItemView.md]

![MenuItemView.png][MenuItemView.png]

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

## 通用

* ###### 输入过滤适配器 | [InputFilterAdapter.md][InputFilterAdapter.md]

```
filterReverse       | 设置反选（反过滤
filterEmoji         | 过滤Emoji表情
filterNumber        | 过滤数字
filterAlphabet      | 过滤字母
filterChinese       | 过滤中文
```

* ###### 防止双击监听 | [DoubleClickListener.md][DoubleClickListener.md]

```
checkDoubleClick    | 拿到双击
onNoDoubleClick     | 过滤双击
```

* ###### 文本变化监听适配器 | [TextWatcherAdapter.md][TextWatcherAdapter.md]

```
beforeTextChanged   | 文本改变之前
onTextChanged       | 文本改变
afterTextChanged    | 文本改变之后
```

## 词典

* ###### 混淆 | [proguard-rules.md][proguard-rules.md]

```
release {
    minifyEnabled true      //开启混淆
    shrinkResources true    //打开资源压缩（去除没有引用的资源）
    zipAlignEnabled true    //zipAlign可以让安装包中的资源按4字节对齐，这样可以减少应用在运行时的内存消耗。
    proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
}
```

## 一句话推荐一个类库

* ###### 工具类库 | [AndroidUtilCode][AndroidUtilCode]

```
工具类解放了双手，得益于AndroidUtilCode，极大提高了工作效率
```

* ###### 黄油刀 | [butterknife][butterknife] & 好基友 | [zelezny][zelezny]

```
依赖注入框架，减少大量的findViewById以及setOnClickListener代码
```

* ###### 图片加载 | [glide][glide]

```
 Google推荐的图片加载库 & 好基友 | [查看图片][PhotoView]
```

* ###### JSON解析 | [gson][gson]

```
序列化Java对象为JSON字符串，或反序列化JSON字符串成Java对象。
```

* ###### 组件、线程通信 | [EventBus][EventBus]

```
简而言之，EventBus是一个事件发布和订阅的框架。
```

* ###### dex分包 | [multidex][multidex]

```
Google提供的android-support-multidex。解决方法65536瓶颈
```

* ###### 滑动退出 | [Slidr][Slidr]

```
轻松添加滑动到Activity的功能
```

* ###### 强大的适配器 | [BaseRecyclerViewAdapterHelper][BaseRecyclerViewAdapterHelper]

```
和原始的adapter相对比，减少70%的代码量。
```

* ###### 消息显示 | [BadgeView][BadgeView]

```
可以自由定制外观、支持拖拽消除的MaterialDesign风格
```

* ###### 状态栏控制 | [ImmersionBar][ImmersionBar]

```
状态栏、导航栏、沉浸式的轻松控制
```

* ###### 自动换行 | [FlexboxLayout][FlexboxLayout]

```
Google新的容器，强大自如换行
```

## Base类

* ###### HyenaActivity | [使用示例][HyenaActivity.md]

* ###### HyenaBaseActivity | [使用示例][HyenaBaseActivity.md]


[languageSvg]:https://img.shields.io/badge/language-java-blue.svg
[jitPackSvg]:https://jitpack.io/v/KnifeStone/Hyena.svg
[jitPack]:https://jitpack.io/#KnifeStone/Hyena
[apiSvg]: https://img.shields.io/badge/API-15+-blue.svg
[api]: https://android-arsenal.com/api?level=15

[Hyena]:https://github.com/KnifeStone/Hyena
[蒲公英下载地址]:https://www.pgyer.com/72qN

[AndroidUtilCode]:https://github.com/Blankj/AndroidUtilCode
[butterknife]:https://github.com/JakeWharton/butterknife
[zelezny]:https://github.com/avast/android-butterknife-zelezny
[glide]:https://github.com/bumptech/glide
[PhotoView]:https://github.com/chrisbanes/PhotoView
[gson]:https://github.com/google/gson
[EventBus]:https://github.com/greenrobot/EventBus
[multidex]:http://blog.csdn.net/gaozhan_csdn/article/details/51992100
[Slidr]:https://github.com/r0adkll/Slidr
[BaseRecyclerViewAdapterHelper]:https://github.com/CymChad/BaseRecyclerViewAdapterHelper
[BadgeView]:https://github.com/qstumn/BadgeView
[ImmersionBar]:https://github.com/gyf-dev/ImmersionBar
[FlexboxLayout]:https://github.com/google/flexbox-layout

[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md

[MenuItemView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/MenuItemView.md
[EyesEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/EyesEditText.md
[ClearEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/ClearEditText.md
[MarqueeTextView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/MarqueeTextView.md
[CountDownButton.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/CountDownButton.md

[HyenaActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaActivity.md
[HyenaBaseActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaBaseActivity.md

[InputFilterAdapter.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/InputFilterAdapter.md
[DoubleClickListener.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/DoubleClickListener.md
[TextWatcherAdapter.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/TextWatcherAdapter.md

[proguard-rules.md]: https://github.com/KnifeStone/Hyena/blob/master/wikis/proguard-rules.md

[MenuItemView.png]:https://github.com/KnifeStone/Hyena/blob/master/files/images/MenuItemView.png