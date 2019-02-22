package com.example.code_foo_android_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.code_foo_android_app.Model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Article> articles;

    public ArticleAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View articleItem = LayoutInflater.from(context)
                .inflate(R.layout.article_item, viewGroup, false);
        return new ArticleAdapter.ViewHolder(articleItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Article article = articles.get(i);

        String articleTitle = article.getMetadata().getHeadline();
        String articleDescription = article.getMetadata().getDescription();
        String image = article.getThumbnailArrayList().get(0).getUrl();

        viewHolder.mArticleTitleView.setText(articleTitle);
        viewHolder.mArticleDescriptionView.setText(articleDescription);

        Glide.with(context).load(image).into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mArticleTitleView;
        private TextView mArticleDescriptionView;
        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mArticleTitleView = itemView.findViewById(R.id.article_title);
            mArticleDescriptionView = itemView.findViewById(R.id.description_tv);
            mImageView = itemView.findViewById(R.id.article_thumbnail);
        }
    }
}
