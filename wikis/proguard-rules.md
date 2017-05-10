###### [proguard-rules.pro][file] | [介绍文章][blog]

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

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/proguard-rules.pro
[blog]:http://www.jianshu.com/p/c703290fe971

