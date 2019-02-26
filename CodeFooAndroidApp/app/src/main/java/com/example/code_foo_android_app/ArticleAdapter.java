package com.example.code_foo_android_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.code_foo_android_app.Model.Article;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        String slug = article.getMetadata().getSlug();
        String url = context.getString(R.string.base_article_url) + slug;

        final Uri articleLink = Uri.parse(url);

        String dateString = article.getMetadata().getPublishDate();

        String timePassed = calcTimestamp(dateString, viewHolder);

        viewHolder.mArticleDateView.setText(timePassed);

        String articleTitle = article.getMetadata().getHeadline();
        String articleDescription = article.getMetadata().getDescription();
        String image = article.getThumbnailArrayList().get(0).getUrl();
        int commentCount = article.getNumComments();

        viewHolder.mArticleTitleView.setText(articleTitle);
        viewHolder.mArticleDescriptionView.setText(articleDescription);
        viewHolder.mArticleCommentView.setText(String.valueOf(commentCount));

        Glide.with(context).load(image).into(viewHolder.mImageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, articleLink);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(articles == null) {
            return 0;
        }
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mArticleTitleView;
        private TextView mArticleDescriptionView;
        private TextView mArticleDateView;
        private TextView mArticleCommentView;
        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mArticleTitleView = itemView.findViewById(R.id.article_title);
            mArticleDescriptionView = itemView.findViewById(R.id.description_tv);
            mArticleDateView = itemView.findViewById(R.id.article_timestamp);
            mArticleCommentView = itemView.findViewById(R.id.comment_count);
            mImageView = itemView.findViewById(R.id.article_thumbnail);
        }
    }

    private String calcTimestamp(String dateString, ViewHolder viewHolder){
        String returnValue = "";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = dateFormat.parse(dateString);
            long dateTime = date.getTime();
            Date currDate = new Date();
            long dateTime2 = currDate.getTime();

            long diff = dateTime2 - dateTime;
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;

            if(days > 0) {
                if(days == 1) {
                    returnValue = "YESTERDAY";
                }
                else {
                    returnValue = days + " DAYS AGO";
                }
            }
            else if(hours > 0) {
                returnValue = hours + " HR AGO";
            }
            else if(minutes > 0) {
                returnValue = minutes + " MIN AGO";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
}
