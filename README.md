# Hyena 鬣狗 高效、精准，为快速开发而生。

[![language][languageSvg]]() [![jitPack][jitPackSvg]][jitPack] [![api][apiSvg]][api]

###### Start Hyena 加入QQ交流群479585883

## 说明 | [更新日志][UpdateLog.md] | [demo.apk][蒲公英下载地址]

像[AndroidUtilCode][AndroidUtilCode]这样优秀的库替我管理了工具类，大大提高了我工作的效率，现在工具类终于解放了双手，这得益于[AndroidUtilCode][AndroidUtilCode]，每当构建新项目，只需要一行代码就可以把需要的工具类引用进来，而且这个库还保持着活跃的更新，更多的人在参与进去，开源的力量让[AndroidUtilCode][AndroidUtilCode]变得愈加强大，也使更多的android开发者收益，再次感谢。

[Hyena鬣狗快速开发库][Hyena]也是借鉴了前辈的思路，想成为一个简单好用，保持活力，受大家喜欢的开源库。
核心为`快速开发`，定位`小巧精悍`，内容`简单精致`，整合`常用的自定义View`、`Base类`、`通用`、`词典`

发扬开源社区精神，欢迎大家的`commits` `issues` `start`

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
    compile 'com.github.KnifeStone:Hyena:最新版本'//如0.8.0
}
```

## 自定义View

* ###### [使用示例][EyesEditText.md] | 带眼睛的输入框

* ###### [使用示例][ClearEditText.md] | 带清除的输入框

* ###### [使用示例][CountDownButton.md] | 倒计时按钮

* ###### [使用示例][MarqueeTextView.md] | 横向跑马灯控件

## 通用

* ###### [使用示例][DoubleClickListener.md] | 防止双击监听

* ###### [使用示例][TextWatcherAdapter.md] | 文本变化监听适配器

## 词典

* ###### [使用示例][proguard-rules.md] | 混淆

[languageSvg]:https://img.shields.io/badge/language-java-blue.svg
[jitPackSvg]:https://jitpack.io/v/KnifeStone/Hyena.svg
[jitPack]:https://jitpack.io/#KnifeStone/Hyena
[apiSvg]: https://img.shields.io/badge/API-15+-blue.svg
[api]: https://android-arsenal.com/api?level=15

[Hyena]:https://github.com/KnifeStone/Hyena
[AndroidUtilCode]:https://github.com/Blankj/AndroidUtilCode
[蒲公英下载地址]:https://www.pgyer.com/72qN


[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md

[EyesEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/EyesEditText.md
[ClearEditText.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/ClearEditText.md
[MarqueeTextView.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/MarqueeTextView.md
[CountDownButton.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/CountDownButton.md

[DoubleClickListener.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/DoubleClickListener.md
[TextWatcherAdapter.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/TextWatcherAdapter.md

[proguard-rules.md]: https://github.com/KnifeStone/Hyena/blob/master/wikis/proguard-rules.md

