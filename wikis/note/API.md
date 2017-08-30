
###### 要使Toolbar 内TextView居中,将偏移设置为0
```
app:contentInsetStart="0dp"
```

###### activity的4种launchMode

```
standard
每次启动这个Activity，就会创建这个Activity的新的实例，并依次放入Back Stack
```

```
singleTop
每次启动这个Activity，如果该Activity在栈顶已经有实例了，就不创建新的实例
```

```
singleTask
每次启动这个Activity，如果栈中已经存在有实例了，复用这个实例，并清除实例到栈顶的所有其它实例
```

```
singleInstance
每次启动这个Activity，会创建一个新的栈
```