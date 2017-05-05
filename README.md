# Hyena 鬣狗快速开发库

[![language][languageSvg]]() [![jitPack][jitPackSvg]][jitPack] [![api][apiSvg]][api]

###### Start Hyena 加入QQ交流群479585883

## 说明 | [更新日志][UpdateLog.md] | [demo.apk](https://www.pgyer.com/72qN)

以快速构建新项目为和，定位小巧精悍，不依赖第三方
整合`常用的自定义View`、`Base类`、`通用`、`词典`
确保提供的内容都是简单，精致的
发扬开源精神，欢迎加入

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

* ###### 带眼睛的输入框 | [EyesEditText.java][EyesEditText.java]

```
<!-- 直接尝用即可 drawable_visibility/drawable_visibility_off 不设置有design风格默认值 -->
<com.knifestone.hyena.view.edittext.EyesEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:inputType="textPassword"
    app:drawable_visibility="@drawable/..."
    app:drawable_visibility_off="@drawable/..." />
```

* ###### 带清除的输入框 | [ClearEditText.java][ClearEditText.java] | [详细说明][ClearEditText.blog]

```
<!-- 直接尝用即可 drawable_close不设置会有个默认黑色的图标 -->
<com.knifestone.hyena.view.edittext.ClearEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:drawable_close="@drawable/..." />
```

* ###### 倒计时按钮 | [CountDownButton.java][CountDownButton.java] | [示例代码][CountDownButton.md]


* ###### 横向跑马灯控件 | [MarqueeTextView.java][MarqueeTextView.java] | [详细说明][MarqueeTextView.blog]

```
<!-- 直接尝用即可 -->
<com.knifestone.hyena.view.textview.MarqueeTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="..."/>
```

## 通用

* ###### 防止双击监听 | [DoubleClickListener.java][DoubleClickListener.java]

```
static void init(long DelayTime)        :静态方法（配置双击间隔时间
static boolean checkDoubleClick()       :静态方法（手动检测是否双击
abstract void onNoDoubleClick(View v)   :当作View.OnClickListener来使用，替换onClick(View v)
```

* ###### 文本变化监听适配器 | [TextWatcherAdapter.java][TextWatcherAdapter.java]

```
editText.addTextChangedListener(new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable editable) {
            //选择性实现需要的方法
        }
    });
```

## 词典

* ###### 混淆 | [proguard-rules.pro][proguard-rules.pro]

```
//Step 1.开启混淆
release {
    minifyEnabled true      //开启混淆
    shrinkResources true    //打开资源压缩（去除没有引用的资源）
    zipAlignEnabled true    //zipAlign可以让安装包中的资源按4字节对齐，这样可以减少应用在运行时的内存消耗。
    proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
}
//Step 2.proguard-rules.pro 里面的代码直接复制使用
```

[languageSvg]:https://img.shields.io/badge/language-java-blue.svg
[jitPackSvg]:https://jitpack.io/v/KnifeStone/Hyena.svg
[jitPack]:https://jitpack.io/#KnifeStone/Hyena
[apiSvg]: https://img.shields.io/badge/API-15+-blue.svg
[api]: https://android-arsenal.com/api?level=15

[Hyena.jpg]:https://github.com/KnifeStone/Hyena/blob/master/images/Hyena.jpg
[UpdateLog.md]: https://github.com/KnifeStone/Hyena/blob/master/UpdateLog.md
[EyesEditText.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/edittext/EyesEditText.java
[ClearEditText.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/edittext/ClearEditText.java
[CountDownButton.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/button/CountDownButton.java
[MarqueeTextView.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/textview/MarqueeTextView.java
[DoubleClickListener.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/currency/DoubleClickListener.java
[TextWatcherAdapter.java]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/currency/TextWatcherAdapter.java
[proguard-rules.pro]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/proguard-rules.pro


[ClearEditText.blog]:http://www.jianshu.com/p/9bcb4111ab3a
[CountDownButton.md]:https://github.com/KnifeStone/Hyena/blob/master/wikis/CountDownButton.md
[MarqueeTextView.blog]:http://www.jianshu.com/p/af2d636b110e