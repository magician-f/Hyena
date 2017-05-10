## 过滤/反过滤 数字、字母、中文、Emoji

###### [InputFilterAdapter.java][file] | [介绍文章][blog]

InputFilterAdapter的灵感来源于这篇文章[原文地址](http://www.jianshu.com/p/b34946b15149) [作者焕然一璐](http://www.jianshu.com/u/70c12759d4fe)

###### 使用示例

```
InputFilterAdapter inputFilter;
//设置过滤数字和中文
inputFilter = new InputFilterAdapter.Builder().filterNumber(true).filterChinese(true).builder();
edittext.setFilters(new InputFilter[]{inputFilter});
//设置反过滤（只允许输入）数字
inputFilter = new InputFilterAdapter.Builder().filterReverse(true).filterNumber(true).builder();
edittext.setFilters(new InputFilter[]{inputFilter});
```

###### API

```
filterReverse       | 设置反选（反过滤
filterEmoji         | 过滤Emoji表情
filterNumber        | 过滤数字
filterAlphabet      | 过滤字母
filterChinese       | 过滤中文
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/currency/InputFilterAdapter.java
[blog]:http://www.jianshu.com/u/6e6858f18e58

