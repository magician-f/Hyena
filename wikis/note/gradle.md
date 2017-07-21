* # 简单高效管理依赖库

```
=====菊个梨子  依赖微信sdk

compile 'com.tencent.mm.opensdk:wechat-sdk-android-without-mta:1.0.2'

=====单个modle 依赖单个库时
（高效、没毛病 ）

=====好个modle，依赖多个相同库
升级的时候，需要修改多处，可能会有疏漏
（低效、易出错）

下面介绍统一管理依赖包的方法
```

###### 使用步骤1.在根目录的build.gradle中配置的示例

```
ext {
    compileSdkVersion = 25
    buildToolsVersion = "25.0.3"

    minSdkVersion = 19
    targetSdkVersion = 25

    appcompat_v7 = "com.android.support:appcompat-v7:25.3.1"
    design = "com.android.support:design:25.3.1"
    cardview = "com.android.support:cardview-v7:25.3.1"
    vector_drawable = "com.android.support:support-vector-drawable:25.3.1"
    constraint_layout = "com.android.support.constraint:constraint-layout:1.0.2"
}
```

###### 使用步骤2.在app（modle）目录中的build.gradle中使用示例

```
android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    defaultConfig {
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode 1
        versionName "1.0"
    }
}

dependencies {
    compile rootProject.ext.appcompat_v7
    compile rootProject.ext.design
    compile rootProject.ext.cardview
    compile rootProject.ext.vector_drawable
    compile rootProject.ext.constraint_layout
}
```

一个有轻度洁癖的 [Hyena鬣狗快速开发库][Hyena] 

[Hyena]:https://github.com/KnifeStone/Hyena