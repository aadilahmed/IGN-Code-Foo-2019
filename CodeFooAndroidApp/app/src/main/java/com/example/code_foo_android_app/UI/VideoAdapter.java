package com.example.code_foo_android_app.UI;

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
import com.example.code_foo_android_app.R;
import com.example.code_foo_android_app.Utils.TimestampCalcUtil;

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
        if(i == 0) {
            View swipeItem = LayoutInflater.from(context)
                    .inflate(R.layout.swipe_item, viewGroup, false);
            return new VideoAdapter.ViewHolder(swipeItem);
        } else {
            View videoItem = LayoutInflater.from(context)
                    .inflate(R.layout.video_item, viewGroup, false);
            return new VideoAdapter.ViewHolder(videoItem);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if(getItemViewType(i) != 0) {
            i--;
            final Video video = videos.get(i);

            String slug = video.getVideoMetadata().getSlug();
            String url = context.getString(R.string.base_video_url) + slug;

            final Uri videoLink = Uri.parse(url);

            String dateString = video.getVideoMetadata().getPublishDate();

            String timePassed = TimestampCalcUtil.calcTimestamp(dateString, viewHolder);

            viewHolder.mVideoDateView.setText(timePassed);

            String videoTitle = video.getVideoMetadata().getTitle();
            String videoDescription = video.getVideoMetadata().getDescription();
            String image = video.getThumbnailArrayList().get(0).getUrl();
            int commentCount = video.getNumComments();

            viewHolder.mVideoTitleView.setText(videoTitle);
            viewHolder.mVideoDescriptionView.setText(videoDescription);
            viewHolder.mVideoCommentView.setText(String.valueOf(commentCount));

            Glide.with(context).load(image).into(viewHolder.mImageView);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, videoLink);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(videos == null) {
            return 0;
        }
        return videos.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        else return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mVideoTitleView;
        private TextView mVideoDescriptionView;
        private TextView mVideoDateView;
        private TextView mVideoCommentView;
        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mVideoTitleView = itemView.findViewById(R.id.video_title);
            mVideoDescriptionView = itemView.findViewById(R.id.video_description_tv);
            mVideoDateView = itemView.findViewById(R.id.video_timestamp);
            mVideoCommentView = itemView.findViewById(R.id.vid_comment_count);
            mImageView = itemView.findViewById(R.id.video_thumbnail);
        }
    }
}
