package com.travisgray.news.Networking;


import com.travisgray.news.Model.GetArticlesResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by travi on 7/19/2018.
 */

public class NewsAPI {

    private static final String APIKEY = "ba1e7ded346341f3b9d1f3c6e994e967";
    private static final String APIPATH = "https://newsapi.org/v2/";

    private static NewsService newsService =  null;

    public static NewsService getApi() {

        if (newsService == null) {
//            Initialize NewsService

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIPATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsService = retrofit.create(NewsService.class);
        }

        return newsService;
    }

    public interface NewsService {
        @GET("top-headlines?sources=reuters&apiKey=" + APIKEY)
        Call<GetArticlesResponse> getArticles(@Query("source") String source, @Query("sortBy") String sortBy);
    }
}
