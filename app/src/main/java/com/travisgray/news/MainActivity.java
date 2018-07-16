package com.travisgray.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.travisgray.news.Model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create a list of News Articles
        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle("The 2018 Gear Post","https://unsplash.com/photos/4x-67z_TaGo","http://www.digitalnomadtips.com/wp-content/uploads/2009/06/digital-nomad-tools.jpg","Today","http://tynan.com/gear2018","We present you a curated packing list of digital nomad travel gear. Become a digital nomad and work from anywhere in the world with these essentials"));


        newsArticles.add(new NewsArticle(
                "title1",
                "https://beta.techcrunch.com/2018/03/10/alibabas-jack-ma-and-joe-tsai-invest-20-million-in-rent-the-runway/",
                "https://imagesvc.timeincapp.com/v3/fan/image?url=https://writingillini.com/wp-content/uploads/getty-images/2017/06/664230540-gonzaga-v-north-carolina.jpg.jpg&c=sc&w=4754&h=3169",
                "2018-10-01","https://beta.techcrunch.com/wp-content/uploads/2018/02/gettyimages-914678410.jpg?w=990&crop=1","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tincidunt diam et diam sollicitudin pharetra. Pellentesque suscipit, sem sed consequat pretium, risus mi mollis sapien, a pulvinar nisi nunc vel risus. In vitae ultricies erat, vel sagittis velit. Aenean sodales, elit a accumsan ultricies, massa ipsum ullamcorper nulla, aliquet rutrum diam mi nec lorem. Nulla facilisi. Curabitur vel ligula a massa molestie rutrum eget et turpis. Donec tempor ante eget enim finibus, at malesuada massa posuere. Suspendisse posuere varius aliquet. Curabitur gravida lorem ante, vitae interdum ex tincidunt id. Nam placerat lorem lacus, ac gravida libero maximus a. Donec porta erat nec nibh convallis pharetra. Ut cursus leo lorem, facilisis mattis ligula vestibulum quis. In pharetra, odio at euismod venenatis, nulla sapien accumsan augue, sit amet rutrum velit sem ut magna. Aenean sit amet condimentum libero. Nulla vestibulum sed urna sed commodo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. ")
        );

        newsArticles.add(new NewsArticle("The 2018 Gear Post","https://unsplash.com/photos/4x-67z_TaGo","http://www.digitalnomadtips.com/wp-content/uploads/2009/06/digital-nomad-tools.jpg","2018-10-01","http://tynan.com/gear2018","We present you a curated packing list of digital nomad travel gear. Become a digital nomad and work from anywhere in the world with these essentials"));


        newsArticles.add(new NewsArticle(
                "title1",
                "https://beta.techcrunch.com/2018/03/10/alibabas-jack-ma-and-joe-tsai-invest-20-million-in-rent-the-runway/",
                "https://beta.techcrunch.com/wp-content/uploads/2018/03/hexapod_bot.jpg?w=730&crop=1",
                "2018-10-01","https://beta.techcrunch.com/wp-content/uploads/2018/02/gettyimages-914678410.jpg?w=990&crop=1","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tincidunt diam et diam sollicitudin pharetra. Pellentesque suscipit, sem sed consequat pretium, risus mi mollis sapien, a pulvinar nisi nunc vel risus. In vitae ultricies erat, vel sagittis velit. Aenean sodales, elit a accumsan ultricies, massa ipsum ullamcorper nulla, aliquet rutrum diam mi nec lorem. Nulla facilisi. Curabitur vel ligula a massa molestie rutrum eget et turpis. Donec tempor ante eget enim finibus, at malesuada massa posuere. Suspendisse posuere varius aliquet. Curabitur gravida lorem ante, vitae interdum ex tincidunt id. Nam placerat lorem lacus, ac gravida libero maximus a. Donec porta erat nec nibh convallis pharetra. Ut cursus leo lorem, facilisis mattis ligula vestibulum quis. In pharetra, odio at euismod venenatis, nulla sapien accumsan augue, sit amet rutrum velit sem ut magna. Aenean sit amet condimentum libero. Nulla vestibulum sed urna sed commodo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. ")
        );

//        Store the array adpater in NewStore
        NewsStore.setNewsArticles(newsArticles);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
        recyclerView.setAdapter(homeNewsAdapter);


    }


}
