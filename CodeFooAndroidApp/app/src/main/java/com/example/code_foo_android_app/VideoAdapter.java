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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        String dateString = video.getVideoMetadata().getPublishDate();

        String timePassed = calcTimestamp(dateString, viewHolder);

        viewHolder.mVideoDateView.setText(timePassed);

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
        private TextView mVideoDateView;
        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mVideoTitleView = itemView.findViewById(R.id.video_title);
            mVideoDescriptionView = itemView.findViewById(R.id.video_description_tv);
            mVideoDateView = itemView.findViewById(R.id.video_timestamp);
            mImageView = itemView.findViewById(R.id.video_thumbnail);
        }
    }

    private String calcTimestamp(String dateString, VideoAdapter.ViewHolder viewHolder){
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
                    returnValue = days + " DAY AGO";
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
