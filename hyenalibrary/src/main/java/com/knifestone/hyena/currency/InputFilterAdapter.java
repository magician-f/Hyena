package com.knifestone.hyena.currency;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简介:输入过滤适配器
 * GitHub https://github.com/KnifeStone
 * 邮箱 378741819@qq.com
 * Created by KnifeStone on 2017/5/10.
 */
public class InputFilterAdapter implements InputFilter {

    private static final String FILTER_EMOJI = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\ud83e\udd00-\ud83e\udfff]|[\u2600-\u27ff]";
    private static final String FILTER_NUMBER = "[0-9]";
    private static final String FILTER_ALPHABET = "[A-Za-z]";
    private static final String FILTER_CHINESE = "[\u4e00-\u9fa5]";

    private Pattern pattern;
    private boolean isReverse;

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (pattern == null) {
            return null;
        }
        Matcher emojiMatcher = pattern.matcher(source);
        if (emojiMatcher.find()) {
            return isReverse ? null : "";
        }
        return isReverse ? "" : null;
    }

    public static class Builder {

        private boolean isReverse;

        private boolean isFilterEmoji;
        private boolean isFilterNumber;
        private boolean isFilterAlphabet;
        private boolean isFilterChinese;

        /**
         * 构建实例
         */
        public InputFilterAdapter builder() {
            InputFilterAdapter filter = new InputFilterAdapter();
            filter.isReverse = isReverse;
            StringBuffer sb = new StringBuffer();
            if (isFilterEmoji) {
                sb.append("|");
                sb.append(FILTER_EMOJI);
            }
            if (isFilterNumber) {
                sb.append("|");
                sb.append(FILTER_NUMBER);
            }
            if (isFilterAlphabet) {
                sb.append("|");
                sb.append(FILTER_ALPHABET);
            }
            if (isFilterChinese) {
                sb.append("|");
                sb.append(FILTER_CHINESE);
            }
            if (sb.length() > 0) {
                sb.replace(0, 1, "");
                filter.pattern = Pattern.compile(sb.toString(), Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            }
            return filter;
        }

        /**
         * 设置反选
         */
        public Builder filterReverse(boolean is) {
            isReverse = is;
            return this;
        }

        /**
         * 过滤Emoji表情
         */
        public Builder filterEmoji(boolean is) {
            isFilterEmoji = is;
            return this;
        }

        /**
         * 过滤数字
         */
        public Builder filterNumber(boolean is) {
            isFilterNumber = is;
            return this;
        }

        /**
         * 过滤字母
         */
        public Builder filterAlphabet(boolean is) {
            isFilterAlphabet = is;
            return this;
        }

        /**
         * 过滤中文
         */
        public Builder filterChinese(boolean is) {
            isFilterChinese = is;
            return this;
        }

    }
}