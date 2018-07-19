package com.travisgray.news;

import com.travisgray.news.Model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by travi on 7/15/2018.
 */

public class NewsStore {

    private static List<Article> newsArticles = new ArrayList<>();


    public static List<Article> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<Article> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
