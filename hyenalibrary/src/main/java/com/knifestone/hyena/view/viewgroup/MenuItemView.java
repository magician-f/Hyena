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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.knifestone.hyena.R;

/**
 * 简介:菜单选项View
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/16.
 */
public class MenuItemView extends RelativeLayout {

    private ImageView ivIconLeft;
    private TextView tvTitle;
    private TextView tvSubTitle;
    private ImageView ivIconRight;
    private Switch aSwitch;
    private View viewLineTop;
    private View viewLineBottom;
    private View viewCenter;

    private MenuItemView(Context context) {
        super(context);
    }

    public MenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            return;
        }
        init();
        initStyle(attrs);
    }

    private void init() {
        Context context = getContext();
        LayoutInflater.from(context).inflate(R.layout.view_menu_item, this, true);
        ivIconLeft = (ImageView) findViewById(R.id.ivIconLeft);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        ivIconRight = (ImageView) findViewById(R.id.ivIconRight);
        aSwitch = (Switch) findViewById(R.id.aSwitch);
        viewLineTop = findViewById(R.id.viewLineTop);
        viewLineBottom = findViewById(R.id.viewLineBottom);
        viewCenter = findViewById(R.id.viewCenter);

    }

    private void initStyle(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.MenuItemViewStyle);
        if (attributes == null) {
            return;
        }
        initIvLeft(attributes);
        initTitle(attributes);
        initIvRight(attributes);
        initSwitch(attributes);
        initSubTitle(attributes);
        initLine(attributes);

        attributes.recycle();
    }

    /**
     * 标题
     */
    private void initTitle(TypedArray attributes) {
        String titleText = attributes.getString(R.styleable.MenuItemViewStyle_tv_title_text);
        if (TextUtils.isEmpty(titleText)) {
            tvTitle.setVisibility(GONE);
        } else {
            tvTitle.setText(titleText);
            //设置颜色
            int color = attributes.getColor(R.styleable.MenuItemViewStyle_tv_title_color, -1);
            if (color != -1) {
                tvTitle.setTextColor(color);
            }
            //设置大小
            int size = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_tv_title_size, -1);
            if (size != -1) {
                size = px2sp(getContext(), size);
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
            }
            //设置左边距
            int marginLeft = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_tv_title_margin_left, -1);
            if (marginLeft != -1) {
                LayoutParams params = (LayoutParams) tvTitle.getLayoutParams();
                params.leftMargin = marginLeft;
            }
        }
    }

    /**
     * 左边icon
     */
    private void initIvLeft(TypedArray attributes) {
        int leftSrc = attributes.getResourceId(R.styleable.MenuItemViewStyle_iv_left_src, -1);
        if (leftSrc == -1) {
            removeView(ivIconLeft);
            ivIconLeft = null;
        } else {
            ivIconLeft.setImageResource(leftSrc);
            //设置大小
            int size = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_iv_left_size, -1);
            if (size != -1) {
                LayoutParams params = (LayoutParams) ivIconLeft.getLayoutParams();
                params.width = size;
                params.height = size;
            }
            //设置左边距
            int marginLeft = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_iv_left_margin_left, -1);
            if (marginLeft != -1) {
                LayoutParams params = (LayoutParams) ivIconLeft.getLayoutParams();
                params.leftMargin = marginLeft;
            }
        }
    }

    /**
     * 右边icon
     */
    private void initIvRight(TypedArray attributes) {
        int rightSrc = attributes.getResourceId(R.styleable.MenuItemViewStyle_iv_right_src, -1);
        if (rightSrc == -1) {
            removeView(ivIconRight);
            ivIconRight = null;
        } else {
            ivIconRight.setImageResource(rightSrc);
            //设置大小
            int size = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_iv_right_size, -1);
            if (size != -1) {
                LayoutParams params = (LayoutParams) ivIconRight.getLayoutParams();
                params.width = size;
                params.height = size;
            }
            //设置右边距
            int marginRight = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_iv_right_margin_right, -1);
            if (marginRight != -1) {
                LayoutParams params = (LayoutParams) ivIconRight.getLayoutParams();
                params.rightMargin = marginRight;
            }
        }
    }

    /**
     * Switch
     */
    private void initSwitch(TypedArray attributes) {
        boolean switchVisibility = attributes.getBoolean(R.styleable.MenuItemViewStyle_switch_visibility, false);
        if (!switchVisibility) {
            removeView(aSwitch);
            aSwitch = null;
        } else {
            aSwitch.setVisibility(VISIBLE);
            boolean checked = attributes.getBoolean(R.styleable.MenuItemViewStyle_switch_checked, false);
            aSwitch.setChecked(checked);
        }
    }

    /**
     * 线
     */
    private void initLine(TypedArray attributes) {
        int lineColor = attributes.getColor(R.styleable.MenuItemViewStyle_v_line_color, -1);
        boolean isLineTop = attributes.getBoolean(R.styleable.MenuItemViewStyle_v_line_top_visibility, false);
        if (!isLineTop) {
            removeView(viewLineTop);
        } else {
            if (lineColor != -1) {
                viewLineTop.setBackgroundColor(lineColor);
            }
            //设置左边距
            int marginLeft = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_v_line_top_margin_left, -1);
            if (marginLeft != -1) {
                LayoutParams params = (LayoutParams) viewLineTop.getLayoutParams();
                params.leftMargin = marginLeft;
            }
            //设置右边距
            int marginRight = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_v_line_top_margin_right, -1);
            if (marginRight != -1) {
                LayoutParams params = (LayoutParams) viewLineTop.getLayoutParams();
                params.rightMargin = marginRight;
            }
            //设置高度
            ((LayoutParams) viewLineTop.getLayoutParams()).height = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_v_line_top_margin_height, 1);
        }
        boolean isLineBottom = attributes.getBoolean(R.styleable.MenuItemViewStyle_v_line_bottom_visibility, false);
        if (!isLineBottom) {
            removeView(viewLineBottom);
        } else {
            if (lineColor != -1) {
                viewLineBottom.setBackgroundColor(lineColor);
            }
            //设置左边距
            int marginLeft = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_v_line_bottom_margin_left, -1);
            if (marginLeft != -1) {
                LayoutParams params = (LayoutParams) viewLineBottom.getLayoutParams();
                params.leftMargin = marginLeft;
            }
            //设置右边距
            int marginRight = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_v_line_bottom_margin_right, -1);
            if (marginRight != -1) {
                LayoutParams params = (LayoutParams) viewLineBottom.getLayoutParams();
                params.rightMargin = marginRight;
            }
            //设置高度
            ((LayoutParams) viewLineTop.getLayoutParams()).height = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_v_line_bottom_margin_height, 1);
        }
    }

    /**
     * 副标题
     */
    private void initSubTitle(TypedArray attributes) {
        String subtitleText = attributes.getString(R.styleable.MenuItemViewStyle_tv_subtitle_text);
        if (!TextUtils.isEmpty(subtitleText)) {
            tvSubTitle.setText(subtitleText);
        }
        //设置颜色
        int color = attributes.getColor(R.styleable.MenuItemViewStyle_tv_subtitle_color, -1);
        if (color != -1) {
            tvSubTitle.setTextColor(color);
        }
        //设置大小
        int size = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_tv_subtitle_size, -1);
        if (size != -1) {
            size = px2sp(getContext(), size);
            tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
        //设置左边距
        int marginLeft = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_tv_subtitle_margin_left, -1);
        if (marginLeft != -1) {
            LayoutParams params = (LayoutParams) tvSubTitle.getLayoutParams();
            params.leftMargin = marginLeft;
        }
        //设置右边距
        int marginRight = attributes.getDimensionPixelSize(R.styleable.MenuItemViewStyle_tv_subtitle_margin_right, -1);
        if (marginRight != -1) {
            LayoutParams params = (LayoutParams) tvSubTitle.getLayoutParams();
            params.rightMargin = marginRight;
        }
        //设置位置
        int gravity = attributes.getInteger(R.styleable.MenuItemViewStyle_tv_subtitle_gravity, 0);
        LayoutParams params = (LayoutParams) tvSubTitle.getLayoutParams();
        if (aSwitch != null) {
            params.addRule(RelativeLayout.RIGHT_OF, aSwitch.getId());
        }
        switch (gravity) {
            //左 默认
            case 0:

                break;
            //右
            case 1:
                tvSubTitle.setGravity(Gravity.END);
                break;
            //下
            case 2:
                if (findViewById(R.id.tvTitle) != null) {
                    ((LayoutParams) tvTitle.getLayoutParams()).addRule(RelativeLayout.ABOVE, viewCenter.getId());
                    params.addRule(RelativeLayout.BELOW, viewCenter.getId());
                    params.addRule(RelativeLayout.ALIGN_LEFT, tvTitle.getId());
                }
                break;
        }
    }

    //设置标题
    public void setTitle(@NonNull String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (tvTitle.getVisibility() != VISIBLE) {
            tvTitle.setVisibility(VISIBLE);
        }
        tvTitle.setText(msg);
    }

    //设置副标题
    public void setSubTitle(@NonNull String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (tvSubTitle.getVisibility() != VISIBLE) {
            tvSubTitle.setVisibility(VISIBLE);
        }
        tvSubTitle.setText(msg);
    }

    //设置Switch监听
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        if (aSwitch == null) {
            return;
        }
        aSwitch.setOnCheckedChangeListener(listener);
    }

    //设置Switch
    public void setChecked(boolean checked) {
        if (aSwitch == null) {
            return;
        }
        aSwitch.setChecked(checked);
    }

    //获得Switch
    public boolean getChecked() {
        if (aSwitch == null) {
            return false;
        }
        return aSwitch.isChecked();
    }

    private int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

}
