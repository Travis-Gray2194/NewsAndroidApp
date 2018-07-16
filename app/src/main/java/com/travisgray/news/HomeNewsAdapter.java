package com.travisgray.news;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.travisgray.news.Model.NewsArticle;

import java.util.List;

/**
 * Created by travi on 7/15/2018.
 */

public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {

    private List<NewsArticle> newsArticles;

    public HomeNewsAdapter(List<NewsArticle> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public HomeNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news,parent,false);
        HomeNewsViewHolder homeNewsViewHolder =  new HomeNewsViewHolder(view);
        return homeNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeNewsViewHolder holder, int position) {
        Log.v("HomeNewsAdapter", "position: " + position);
        NewsArticle newsArticle = newsArticles.get(position);
        Glide.with(holder.cardImageView.getContext())
                .load(newsArticle.getImageUrl())
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(holder.cardImageView);

        Log.v("HomeNewsAdapter", newsArticles.get(position).getImageUrl());

        holder.cardTitleTextView.setText(newsArticle.getTitle());
        holder.cardTimeTextView.setText(newsArticle.getTime());
        holder.cardContentTextView.setText(newsArticle.getContent());


    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public static class HomeNewsViewHolder extends RecyclerView.ViewHolder {

        ImageView cardImageView;
        TextView cardTitleTextView;
        TextView cardTimeTextView;
        TextView cardContentTextView;

        public HomeNewsViewHolder(View itemView) {
            super(itemView);
            cardImageView = (ImageView) itemView.findViewById(R.id.card_news_image);
            cardTitleTextView = (TextView) itemView.findViewById(R.id.card_news_title);
            cardTimeTextView = (TextView) itemView.findViewById(R.id.card_news_time);
            cardContentTextView = (TextView) itemView.findViewById(R.id.card_news_content);
        }
    }
}
