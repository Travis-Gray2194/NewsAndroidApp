package com.travisgray.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.travisgray.news.Model.GetArticlesResponse;
import com.travisgray.news.Model.NewsArticle;
import com.travisgray.news.Networking.NewsAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.travisgray.news.Networking.NewsAPI.getApi;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Call<GetArticlesResponse> call = NewsAPI.getApi().getArticles("reuters","top");
        call.enqueue(new Callback<GetArticlesResponse>() {

            @Override
            public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {
                GetArticlesResponse getArticlesResponse = response.body();
                NewsStore.setNewsArticles(getArticlesResponse.getArticles());
                Toast.makeText(MainActivity.this, "Response received",Toast.LENGTH_SHORT).show();
                HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(getArticlesResponse.getArticles());
                recyclerView.setAdapter(homeNewsAdapter);
            }

            @Override
            public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error received",Toast.LENGTH_SHORT).show();


            }
        });

    }


}
