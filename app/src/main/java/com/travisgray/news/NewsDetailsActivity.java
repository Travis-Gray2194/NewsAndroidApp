package com.travisgray.news;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NewsDetailsActivity extends AppCompatActivity {

    private WebView webview;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        webview = (WebView) findViewById(R.id.activity_news_details_webview);
        progressBar = (ProgressBar) findViewById(R.id.activity_news_details_progressbar);
    }

    public void UpdateNewsDetails (int index){

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(NewsDetailsActivity.this,"Error in loading webpage",Toast.LENGTH_SHORT).show();
            }
        });
        webview.loadUrl(NewsStore.getNewsArticles().get(index).getUrlToArticle());
        getSupportActionBar().setTitle(NewsStore.getNewsArticles().get(index).getTitle());
    }
}
