package com.knifestone.hyena.view.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.knifestone.hyena.R;

/**
 * 简介:菜单视图
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/16.
 */
public class MenuItemView extends RelativeLayout {

    private ImageView itemIvIcon;
    private TextView itemTvTitle;
    private TextView itemTvContent;
    private ImageView itemIvRight;
    private View itemViewLine;

    private MenuItemView(Context context) {
        super(context);
    }

    public MenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        Context context = getContext();
        LayoutInflater.from(context).inflate(R.layout.view_menu_item, this, true);
        itemIvIcon = (ImageView) findViewById(R.id.itemIvIcon);
        itemTvTitle = (TextView) findViewById(R.id.itemTvTitle);
        itemTvContent = (TextView) findViewById(R.id.itemTvContent);
        itemIvRight = (ImageView) findViewById(R.id.itemIvRight);
        itemViewLine = findViewById(R.id.itemViewLine);
    }

    private void initStyle(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.MenuItemViewStyle);
        if (attributes == null) {
            return;
        }
        //layoutBackground
        int layoutBackground = attributes.getResourceId(R.styleable.MenuItemViewStyle_layout_background, android.R.attr.selectableItemBackground);
        if (layoutBackground != -1) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
            setBackgroundResource(typedValue.resourceId);
        } else {
            setBackgroundResource(layoutBackground);
        }
        //iconSrc
        int iconSrc = attributes.getResourceId(R.styleable.MenuItemViewStyle_iv_icon_src, -1);
        if (iconSrc == -1) {
            itemIvIcon.setVisibility(View.GONE);
        } else {
            itemIvIcon.setVisibility(View.VISIBLE);
            itemIvIcon.setImageResource(iconSrc);
        }
        //itemTvTitle
        String titleStr = attributes.getString(R.styleable.MenuItemViewStyle_tv_title_string);
        if (!TextUtils.isEmpty(titleStr)) {
            itemTvTitle.setText(titleStr);
            //设置左边按钮文字颜色
//            int leftButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_left_button_text_color, Color.WHITE);
//            titleBarLeftBtn.setTextColor(leftButtonTextColor);
        }
        //itemTvContent
        String contentStr = attributes.getString(R.styleable.MenuItemViewStyle_tv_content_text);
        if (!TextUtils.isEmpty(contentStr)) {
            itemTvContent.setText(titleStr);
        }
        int gravity = attributes.getInteger(R.styleable.MenuItemViewStyle_tv_content_gravity,0);
        if (gravity==1){
            itemTvContent.setGravity(Gravity.RIGHT);
        }
        //ivRight
        int rightSrc = attributes.getResourceId(R.styleable.MenuItemViewStyle_iv_right_src, -1);
        if (rightSrc == -1) {
            itemIvRight.setVisibility(View.GONE);
        } else {
            itemIvRight.setVisibility(View.VISIBLE);
            itemIvRight.setImageResource(rightSrc);
        }
        //itemViewLine
        boolean isLine = attributes.getBoolean(R.styleable.MenuItemViewStyle_v_line_visibility, false);
        itemViewLine.setVisibility(isLine ? VISIBLE : GONE);
        attributes.recycle();
    }

    //设置内容
    public void setItemContent(@NonNull String msg){
        if (TextUtils.isEmpty(msg)){
            return;
        }
        if (itemTvContent.getVisibility()!=VISIBLE) {
            itemTvContent.setVisibility(VISIBLE);
        }
        itemTvContent.setText(msg);
    }

}
