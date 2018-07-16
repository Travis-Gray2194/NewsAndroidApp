package com.travisgray.news;

import com.travisgray.news.Model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by travi on 7/15/2018.
 */

public class NewsStore {

    private static List<NewsArticle> newsArticles = new ArrayList<>();


    public static List<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<NewsArticle> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
