# "高效、精准，鬣狗为快速开发而生。"

[![language][languageSvg]]() [![jitPack][jitPackSvg]][jitPack] [![api][apiSvg]][api]

###### Start Hyena 加入QQ交流群479585883

## 说明 | [更新日志][UpdateLog.md] | [demo.apk][蒲公英下载地址]

[Hyena鬣狗快速开发库][Hyena]核心为`快速开发`，定位`小巧精悍`，内容`简单精致`，整合`常用View`、`Base类`、`通用`、`词典`、`推荐类库`


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
    compile 'com.android.support:appcompat-v7:25.3.0'
    compile 'com.github.KnifeStone:Hyena:最新版本'//如1.0.0
}
```

## 常用View

* ###### [EyesEditText.md][EyesEditText.md] | 带眼睛的输入框

```
app:drawable_tint="@color/..."                  | icon着色
app:drawable_follow_focus="true|false"          | 跟随焦点
app:drawable_visibility="@drawable/..."         | 明文图标
app:drawable_visibility_off="@drawable/..."     | 密文图标
```

* ###### [ClearEditText.md][ClearEditText.md] | 带清除的输入框

```
app:drawable_tint="@color/..."                  | icon着色
app:drawable_follow_focus="true|false"          | 跟随焦点
app:drawable_clear="@drawable/..."              | 图标
```

* ###### [CountDownButton.md][CountDownButton.md] | 倒计时按钮

```
onStart()           | 开始倒计时（默认总时长60s、默认计时间隔1s
onStart(long)       | 开始倒计时（自定义总时长、默认计时间隔
onStart(long,long)  | 开始倒计时（自定义总时长、自定义计时间隔
onStop()            | 结束倒计时
isCountDown()       | 是否在倒计时中
```

* ###### [MarqueeTextView.md][MarqueeTextView.md] | 横向跑马灯控件

```
//开袋即食
<com.knifestone.hyena.view.textview.MarqueeTextView
    .../>
```

## Base类

* ###### [使用示例][HyenaBaseActivity.md] | HyenaBaseActivity

* ###### [使用示例][HyenaToolbarActivity.md] | HyenaToolbarActivity

## 通用

* ###### [InputFilterAdapter.md][InputFilterAdapter.md] | 输入过滤适配器

```
filterReverse       | 设置反选（反过滤
filterEmoji         | 过滤Emoji表情
filterNumber        | 过滤数字
filterAlphabet      | 过滤字母
filterChinese       | 过滤中文
```

* ###### [DoubleClickListener.md][DoubleClickListener.md] | 防止双击监听

```
checkDoubleClick    | 拿到双击
onNoDoubleClick     | 过滤双击
```

* ###### [TextWatcherAdapter.md][TextWatcherAdapter.md] | 文本变化监听适配器

```
beforeTextChanged   | 文本改变之前
onTextChanged       | 文本改变
afterTextChanged    | 文本改变之后
```

## 词典

* ###### [proguard-rules.md][proguard-rules.md] | 混淆

```
release {
    minifyEnabled true      //开启混淆
    shrinkResources true    //打开资源压缩（去除没有引用的资源）
    zipAlignEnabled true    //zipAlign可以让安装包中的资源按4字节对齐，这样可以减少应用在运行时的内存消耗。
    proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
}
```

## 推荐类库

* ###### 工具类库 | [AndroidUtilCode][AndroidUtilCode]

```
推荐星数 ★★★★★
工具类终于解放了双手，这得益于AndroidUtilCode，极大提高了工作效率，每当构建新项目，只需要一行代码就可以使用这得益于AndroidUtilCode，而且更多的人在参与进去，开源的力量让AndroidUtilCode变得愈加强大。
```

* ###### multidex | [dex分包][multidex]

```
推荐星数 ★★★★
Google提供的android-support-multidex.jar
```

* ###### 滑动退出 | [Slidr][Slidr]

```
推荐星数 ★★★★
轻松添加滑动到Activity的功能
```

[languageSvg]:https://img.shields.io/badge/language-java-blue.svg
[jitPackSvg]:https://jitpack.io/v/KnifeStone/Hyena.svg
[jitPack]:https://jitpack.io/#KnifeStone/Hyena
[apiSvg]: https://img.shields.io/badge/API-15+-blue.svg
[api]: https://android-arsenal.com/api?level=15

[Hyena]:https://github.com/KnifeStone/Hyena
[蒲公英下载地址]:https://www.pgyer.com/72qN

[AndroidUtilCode]:https://github.com/Blankj/AndroidUtilCode
[Slidr]:https://github.com/r0adkll/Slidr
[multidex]:http://blog.csdn.net/gaozhan_csdn/article/details/51992100


[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md

[EyesEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/EyesEditText.md
[ClearEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/ClearEditText.md
[MarqueeTextView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/MarqueeTextView.md
[CountDownButton.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/CountDownButton.md

[HyenaBaseActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaBaseActivity.md
[HyenaToolbarActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaToolbarActivity.md

[InputFilterAdapter.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/InputFilterAdapter.md
[DoubleClickListener.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/DoubleClickListener.md
[TextWatcherAdapter.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/TextWatcherAdapter.md

[proguard-rules.md]: https://github.com/KnifeStone/Hyena/blob/master/wikis/proguard-rules.md

