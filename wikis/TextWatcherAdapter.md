###### [TextWatcherAdapter.java][file] | [介绍文章][blog]

```
//设置addTextChangedListener
editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//使用TextWatcherAdapter
editText.addTextChangedListener(new TextWatcherAdapter() {
    @Override
    public void afterTextChanged(Editable editable) {
        //选择性实现需要的方法
    }
});
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/currency/TextWatcherAdapter.java
[blog]:http://www.jianshu.com/u/6e6858f18e58

