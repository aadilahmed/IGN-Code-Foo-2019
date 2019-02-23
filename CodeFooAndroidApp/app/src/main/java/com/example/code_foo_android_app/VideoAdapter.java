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
import com.example.code_foo_android_app.Model.Video;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Video> videos;

    public VideoAdapter(ArrayList<Video> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View videoItem = LayoutInflater.from(context)
                .inflate(R.layout.video_item, viewGroup, false);
        return new VideoAdapter.ViewHolder(videoItem);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder viewHolder, int i) {
        final Video video = videos.get(i);

        String slug = video.getVideoMetadata().getSlug();
        String url = context.getString(R.string.base_video_url) + slug;

        final Uri videoLink = Uri.parse(url);

        String videoTitle = video.getVideoMetadata().getTitle();
        String videoDescription = video.getVideoMetadata().getDescription();
        String image = video.getThumbnailArrayList().get(0).getUrl();

        viewHolder.mVideoTitleView.setText(videoTitle);
        viewHolder.mVideoDescriptionView.setText(videoDescription);

        Glide.with(context).load(image).into(viewHolder.mImageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, videoLink);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mVideoTitleView;
        private TextView mVideoDescriptionView;
        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mVideoTitleView = itemView.findViewById(R.id.video_title);
            mVideoDescriptionView = itemView.findViewById(R.id.video_description_tv);
            mImageView = itemView.findViewById(R.id.video_thumbnail);
        }
    }
}
