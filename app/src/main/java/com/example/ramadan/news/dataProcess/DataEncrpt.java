package com.example.ramadan.news.dataProcess;

/**
 * Created by ramadan on 4/2/2017.
 */
public class DataEncrpt {


    String urllink;
    String image;
    String Desc;
    String Title;

    public DataEncrpt() {
    }

    public DataEncrpt(String url, String image, String desc, String title) {
        this.urllink = url;
        this.image = image;
        Desc = desc;
        Title = title;
    }

    public String getUrl() {
        return urllink;
    }

    public void setUrl(String url) {
        this.urllink = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
