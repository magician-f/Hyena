###### [MenuItemView.java][file] | [介绍文章][blog]

###### 可以设置的属性

```
<declare-styleable name="MenuItemViewStyle">

        <attr name="iv_left_src" format="reference" />
        <attr name="iv_left_size" format="dimension" />
        <attr name="iv_left_margin_left" format="dimension" />

        <attr name="tv_title_text" format="string" />
        <attr name="tv_title_color" format="color" />
        <attr name="tv_title_size" format="dimension" />
        <attr name="tv_title_margin_left" format="dimension" />
        <attr name="tv_title_margin_right" format="dimension" />

        <attr name="tv_subtitle_text" format="string" />
        <attr name="tv_subtitle_color" format="color" />
        <attr name="tv_subtitle_size" format="dimension" />
        <attr name="tv_subtitle_margin_left" format="dimension" />
        <attr name="tv_subtitle_margin_right" format="dimension" />
        <attr name="tv_subtitle_gravity" format="integer">
            <enum name="left" value="0" />
            <enum name="right" value="1" />
            <enum name="bottom" value="2" />
        </attr>

        <attr name="iv_right_src" format="reference" />
        <attr name="iv_right_size" format="dimension" />
        <attr name="iv_right_margin_right" format="dimension" />

        <attr name="switch_visibility" format="boolean" />
        <attr name="switch_checked" format="boolean" />

        <attr name="v_line_color" format="color" />

        <attr name="v_line_top_visibility" format="boolean" />
        <attr name="v_line_top_margin_left" format="dimension" />
        <attr name="v_line_top_margin_right" format="dimension" />
        <attr name="v_line_top_margin_height" format="dimension" />

        <attr name="v_line_bottom_visibility" format="boolean" />
        <attr name="v_line_bottom_margin_left" format="dimension" />
        <attr name="v_line_bottom_margin_right" format="dimension" />
        <attr name="v_line_bottom_margin_height" format="dimension" />
    </declare-styleable>
```

###### 公开的方法

```
setTitle                    | 设置标题
setSubTitle                 | 设置副标题
setOnCheckedChangeListener  | 设置Switch监听
setChecked                  | 设置Switch
getChecked                  | 获得Switch
```

[file]: https://github.com/KnifeStone/Hyena/blob/master/hyenalibrary/src/main/java/com/knifestone/hyena/view/viewgroup/MenuItemView.java
[blog]: http://www.jianshu.com/u/6e6858f18e58

