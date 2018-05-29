package com.wuwo.fangdaidemo.entity;

import android.widget.ImageView;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.entity
 * 文件名：ListBean
 * 创建者：SGY
 * Created by 2018/5/25 16:45
 * 描述：TODO
 */

public class ListBean{
    private String id;
    private String title;
    private String source;
    private ImageView firstImg;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ImageView getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(ImageView firstImg) {
        this.firstImg = firstImg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
