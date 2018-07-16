package com.travisgray.news.Model;

/**
 * Created by travi on 7/15/2018.
 */

public class NewsArticle {

    String title;
    String imageUrl;
    String urlToArticle;
    String time;
    String content;

    public NewsArticle(String title, String details, String imageUrl, String time, String urlToArticle, String content) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.time = time;
        this.urlToArticle = urlToArticle;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrlToArticle() {
        return urlToArticle;
    }

    public void setUrlToArticle(String urlToArticle) {
        this.urlToArticle = urlToArticle;
    }
}
