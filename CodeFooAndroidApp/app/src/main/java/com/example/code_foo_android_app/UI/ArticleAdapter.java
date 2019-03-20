package com.example.code_foo_android_app.UI;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.code_foo_android_app.Model.Article;
import com.example.code_foo_android_app.R;
import com.example.code_foo_android_app.Utils.TimestampCalcUtil;

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
        if (i == 0) {
            View swipeItem = LayoutInflater.from(context)
                    .inflate(R.layout.swipe_item, viewGroup, false);
           return new ArticleAdapter.ViewHolder(swipeItem);
        } else {
            View articleItem = LayoutInflater.from(context)
                    .inflate(R.layout.article_item, viewGroup, false);
            return new ArticleAdapter.ViewHolder(articleItem);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if(getItemViewType(i) != 0) {
            i--;
            final Article article = articles.get(i);

            String slug = article.getMetadata().getSlug();
            String url = context.getString(R.string.base_article_url) + slug;

            final Uri articleLink = Uri.parse(url);

            String dateString = article.getMetadata().getPublishDate();

            String timePassed = TimestampCalcUtil.calcTimestamp(dateString, viewHolder);

            viewHolder.mArticleDateView.setText(timePassed);

            String articleTitle = article.getMetadata().getHeadline();
            String articleDescription = article.getMetadata().getDescription();
            String image = article.getThumbnailArrayList().get(0).getUrl();
            int commentCount = article.getNumComments();

            viewHolder.mArticleTitleView.setText(articleTitle);
            viewHolder.mArticleDescriptionView.setText(articleDescription);
            viewHolder.mArticleCommentView.setText(String.valueOf(commentCount));
            viewHolder.mCardView.setRadius(context.getResources()
                    .getInteger(R.integer.cardCornerRadius));

            Glide.with(context).load(image).into(viewHolder.mImageView);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, articleLink);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(articles == null) {
            return 0;
        }
        return articles.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        else return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mArticleTitleView;
        private TextView mArticleDescriptionView;
        private TextView mArticleDateView;
        private TextView mArticleCommentView;
        private ImageView mImageView;
        private CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mArticleTitleView = itemView.findViewById(R.id.article_title);
            mArticleDescriptionView = itemView.findViewById(R.id.description_tv);
            mArticleDateView = itemView.findViewById(R.id.article_timestamp);
            mArticleCommentView = itemView.findViewById(R.id.comment_count);
            mImageView = itemView.findViewById(R.id.article_thumbnail);
            mCardView = itemView.findViewById(R.id.thumbnail_frame);
        }
    }
}
