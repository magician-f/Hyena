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

## [常用View][Views.md]

## [Base][Base.md]

## [通用][Currency.md]

## [一句话推荐一个类库][Library.md]

## [AndroidStudio插件][Plug.md]

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
[Librarys.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Library.md
[Plugs.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Plugs.md

[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md

[HyenaActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaActivity.md
[HyenaBaseActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaBaseActivity.md

[proguard-rules.md]: https://github.com/KnifeStone/Hyena/blob/master/wikis/proguard-rules.md

