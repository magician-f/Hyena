###### [DoubleClickListener.md][file] | [介绍文章][blog]

```
//初始化 双击间隔判定 默认400
DoubleClickListener.init(delayTime);

//使用场景1.拿到双击事件
@Override
public void onClick(View v) {
    if(DoubleClickListener.checkDoubleClick()){
       //双击了
    }
}

//使用场景2.设置的点击监听过滤双击事件
view.setOnClickListener(new DoubleClickListener() {
    @Override
    public void onNoDoubleClick(View v) {
        //过滤了双击
    }
});
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/currency/DoubleClickListener.java
[blog]:http://www.jianshu.com/u/6e6858f18e58

