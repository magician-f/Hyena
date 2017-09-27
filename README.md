# "Hyena 一个有轻度洁癖的Android快速开发库"

[![language][languageSvg]]() [![jitPack][jitPackSvg]][jitPack] [![api][apiSvg]][api]

* #### 兄弟仓库[HyenaQQ(2行代码实现qq登录)][HyenaQQ]

## 简介 | [更新日志][UpdateLog.md] | [demo.apk][蒲公英下载地址]

* hyena仓库功能
`强大彪悍的base`
`易用方便的function`
`常规场景的view`
`减少冗余的currency`

* 在线资料
`词典、笔记`
`一句话推荐一个类库`
`AndroidStudio插件`

## 如何使用

###### Step 1. 添加jitpack库到根目录build.gradle

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

###### Step 2. 添加依赖关系

```
dependencies {
    compile 'com.android.support:appcompat-v7:25.3.1'//自行调整版本
    compile "com.android.support:design:25.3.1"
    compile 'com.github.KnifeStone:Hyena:1.3.7'
}
```

## hyena仓库功能

###### [Base][Base.md]

```
HyenaBaseActivity
HyenaToolbarActivity
HyenaWhereGoActivity
```

###### [功能][Function.md]

```
版本更新
```

###### [常用View][Views.md]

```
菜单选项View
简单选择器
带眼睛的输入框
带清除的输入框
倒计时按钮
横向跑马灯控件
```

###### [通用][Currency.md]

```
输入过滤适配器
防止双击监听
文本变化监听适配器
过时方法适配器
```

## 在线资料

###### [词典、笔记][Note.md]

```
混淆
gradle
冷门API
```

###### [一句话推荐一个类库][Library.md]

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
一个增强BottomNavigationView的安卓库
NiceDialog,基于DialogFragment的扩展
```

###### [AndroidStudio插件][Plug.md]

```
AndroidStudio插件
gson数据自动生成实体类
在类中插入实现了Parcelable接口的代码
翻译插件,可以将英文翻译为中文
将项目中的 string 资源自动翻译为其他语言
自动生成6.0权限的代码
统计Android依赖库中方法的总个数
一键findViewById
代码快速定位，AS中的Minimap
告别postman，测试接口的功能
```

[languageSvg]:https://img.shields.io/badge/language-java-blue.svg
[jitPackSvg]:https://jitpack.io/v/KnifeStone/Hyena.svg
[jitPack]:https://jitpack.io/#KnifeStone/Hyena
[apiSvg]: https://img.shields.io/badge/API-15+-blue.svg
[api]: https://android-arsenal.com/api?level=15

[HyenaQQ]:https://github.com/KnifeStone/HyenaQQ
[Hyena]:https://github.com/KnifeStone/Hyena
[蒲公英下载地址]:https://www.pgyer.com/72qN

[Base.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Base.md
[Function.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Function.md
[Views.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Views.md
[Currency.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Currency.md
[Note.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Note.md
[Library.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Library.md
[Plug.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/catalog/Plug.md

[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md

[HyenaActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaActivity.md
[HyenaBaseActivity.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/HyenaBaseActivity.md


