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
    compile 'com.github.KnifeStone:Hyena:1.2.5'
}
```

# [常用View][Views.md]

```
菜单选项View
简单选择器
带眼睛的输入框
带清除的输入框
倒计时按钮
横向跑马灯控件
```

## [Base][Base.md]

```
HyenaBaseActivity
HyenaToolbarActivity
HyenaWhereGoActivity
```

### [通用][Currency.md]

```
输入过滤适配器
防止双击监听
文本变化监听适配器
```

#### [一句话推荐一个类库][Library.md]

```
工具类库
黄油刀
图片加载
JSON解析
组件、线程通信
dex分包
滑动退出
强大的适配器
消息显示
状态栏控制
自动换行布局
高度封装的WebView
```

##### [AndroidStudio插件][Plug.md]

```
AndroidStudio插件
gson数据自动生成实体类
在类中插入实现了Parcelable接口的代码
翻译插件,可以将英文翻译为中文
将项目中的 string 资源自动翻译为其他语言
自动生成6.0权限的代码
统计Android依赖库中方法的总个数
```

###### 词典

* ###### 混淆 | [proguard-rules.md][proguard-rules.md]

```
release {
    minifyEnabled true      //开启混淆
    shrinkResources true    //打开资源压缩（去除没有引用的资源）
    zipAlignEnabled true    //zipAlign可以让安装包中的资源按4字节对齐，这样可以减少应用在运行时的内存消耗。
    proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
}
```

[languageSvg]:https://img.shields.io/badge/language-java-blue.svg
[jitPackSvg]:https://jitpack.io/v/KnifeStone/Hyena.svg
[jitPack]:https://jitpack.io/#KnifeStone/Hyena
[apiSvg]: https://img.shields.io/badge/API-15+-blue.svg
[api]: https://android-arsenal.com/api?level=15

[Hyena]:https://github.com/KnifeStone/Hyena
[蒲公英下载地址]:https://www.pgyer.com/72qN

[Views.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Views.md
[Base.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Base.md
[Currency.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Currency.md
[Library.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Library.md
[Plug.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Plugs.md

[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md

[HyenaActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaActivity.md
[HyenaBaseActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaBaseActivity.md

[proguard-rules.md]: https://github.com/KnifeStone/Hyena/blob/master/wikis/proguard-rules.md

