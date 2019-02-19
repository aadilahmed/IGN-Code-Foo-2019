package com.example.code_foo_android_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.code_foo_android_app.Model.Content;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Content> articles;

    public ArticleAdapter(ArrayList<Content> articles) {
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
        final Content article = articles.get(i);

        String articleTitle = article.getMetadata().getHeadline();
        String articleDescription = article.getMetadata().getDescription();

        viewHolder.mArticleTitleView.setText(articleTitle);
        viewHolder.mArticleDescriptionView.setText(articleDescription);
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
