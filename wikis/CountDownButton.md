###### Step 1. xml中使用

```
<com.knifestone.hyena.view.button.CountDownButton
        android:id="@+id/countDownButton"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:text="默认（60秒倒计时 间隔1秒）" />
```

###### Step 2. java中代码

```
final CountDownButton countDownButton = (CountDownButton) findViewById(R.id.countDownButton);
countDownButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        countDownButton.onStart();
    }

```

###### api

```
onStart()           :开始倒计时（默认总时长60s、默认计时间隔1s
onStart(long)       :开始倒计时（自定义总时长、默认计时间隔
onStart(long,long)  :开始倒计时（自定义总时长、自定义计时间隔
onStop()            :结束倒计时
isCountDown()       :是否在倒计时中
```

