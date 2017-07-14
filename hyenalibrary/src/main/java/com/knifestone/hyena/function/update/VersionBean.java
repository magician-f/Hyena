package com.knifestone.hyena.function.update;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 版本升级实体类
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-11.
 */
public class VersionBean implements Parcelable {

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
    public int downId;

    public VersionBean(int versionCode, String versionName, String title, String content, String packageUrl, String packageSize, int strategy, int targetCode) {
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.title = title;
        this.content = content;
        this.packageUrl = packageUrl;
        this.packageSize = packageSize;
        this.strategy = strategy;
        this.targetCode = targetCode;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.versionCode);
        dest.writeString(this.versionName);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.packageUrl);
        dest.writeString(this.packageSize);
        dest.writeInt(this.strategy);
        dest.writeInt(this.targetCode);
    }

    protected VersionBean(Parcel in) {
        this.versionCode = in.readInt();
        this.versionName = in.readString();
        this.title = in.readString();
        this.content = in.readString();
        this.packageUrl = in.readString();
        this.packageSize = in.readString();
        this.strategy = in.readInt();
        this.targetCode = in.readInt();
    }

    public static final Creator<VersionBean> CREATOR = new Creator<VersionBean>() {
        @Override
        public VersionBean createFromParcel(Parcel source) {
            return new VersionBean(source);
        }

        @Override
        public VersionBean[] newArray(int size) {
            return new VersionBean[size];
        }
    };
}
