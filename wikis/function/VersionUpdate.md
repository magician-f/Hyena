* # 几行代码实现版本升级（适配6.0）

* ##### 1.先来认识一个实体类 HyenaVersionBean

```
// 版本号
public int versionCode;
// 版本名
public String versionName;
// 标题
public String title;
// 描述
public String content;
// 下载地址
public String packageUrl;
// 安装包大小
public String packageSize;

/**
*  更新策略
*  0   提示更新
*  1   对所有低于版本的强制更新
*  2   对指定版本的强制更新
*  3   对某个版本以下的强制更新
*/
public int strategy;
// 目标版本
public int targetCode;
// 在下载器中的id
public long downId;
```

* ##### 2.在需要更新地方 执行以下示例代码

```
public void 提示更新(View v) {
    if (bean==null) {
        bean = new HyenaVersionBean(
                999,
                "9.9.9",
                "简约新版本袭来",
                "更多的可乐，鸡翅，啤酒\n特别的好",
                "http://bmob-cdn-9047.b0.upaiyun.com/2017/07/17/4fde789940d48d038003048e1e39a6e5.apk",
                "2",
                0,
                0,
                0);
    }
    HyenaUpdateActivity.launchUpdate(this, bean, true, 1);
}
```

* ##### 3.HyenaUpdateActivity 启动API

```
/**
 * 启动更新
 *
 * @param context 上下文
 * @param bean    传入版本数据
 * @param isToast 是否toast
 * @param requestCode 页面回调
 */
public static void launchUpdate(Activity context, HyenaVersionBean bean, boolean isToast, int requestCode) {
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode==  &&resultCode ==RESULT_OK){
        bean = data.getParcelableExtra("bean");
    }
}
```


