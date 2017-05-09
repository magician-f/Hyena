###### [HyenaBaseActivity.java][file] | [介绍文章][blog]

```
public class MainActivity extends HyenaBaseActivity {

     /**
     * 1.继承HyenaBaseActivity
     * 2.实现三个抽象方法
     *  mContext    上下文对象
     *  TAG         包含了类名和线程名
     */

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
        //setContextView(new View(mContext));
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

}
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/base/HyenaBaseActivity.java
[blog]:http://www.jianshu.com/u/6e6858f18e58

