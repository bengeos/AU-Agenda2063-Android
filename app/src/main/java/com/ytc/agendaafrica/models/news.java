package com.ytc.agendaafrica.models;

/**
 * Created by kzone on 6/17/2017.
 */

public class news {
    private int id;
    private String newstitle;
    private String newsdetail;
    private String newsimg;
    private String time;
    private String publisher;
    private String location;

    public news(int id, String newstitle, String newsdetail, String newsimg, String time, String publisher, String location) {
        this.id = id;
        this.newstitle = newstitle;
        this.newsdetail = newsdetail;
        this.newsimg = newsimg;
        this.time = time;
        this.publisher = publisher;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewsdetail() {
        return newsdetail;
    }

    public void setNewsdetail(String newsdetail) {
        this.newsdetail = newsdetail;
    }

    public String getNewsimg() {
        return newsimg;
    }

    public void setNewsimg(String newsimg) {
        this.newsimg = newsimg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public news() {
    }


}
