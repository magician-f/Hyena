package com.knifestone.hyena.bean;

/**
 * 下载实体类
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-7-11.
 */
public class DownBean {

    public long downId;
    public String localUrl;
    public String url;
    public int compeleteSize;
    public int totalSize;
    public int status;

    public DownBean(long downId, String localUrl, String url, int compeleteSize, int totalSize, int status) {
        this.downId = downId;
        this.localUrl = localUrl;
        this.url = url;
        this.compeleteSize = compeleteSize;
        this.totalSize = totalSize;
        this.status = status;
    }
}
