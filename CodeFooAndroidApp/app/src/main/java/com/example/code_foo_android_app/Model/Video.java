package com.example.code_foo_android_app.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Video {
    @SerializedName("contentId")
    private String contentId;
    @SerializedName("contentType")
    private String contentType;
    @SerializedName("metadata")
    private VideoMetadata metadata;
    @SerializedName("thumbnails")
    private ArrayList<Thumbnail> thumbnailList;
    @SerializedName("tags")
    private ArrayList<String> tags;

    public Video(String contentId, String contentType, VideoMetadata metadata,
                   ArrayList<Thumbnail> thumbnails, ArrayList<String> tags) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.metadata = metadata;
        this.thumbnailList = thumbnails;
        this.tags = tags;
    }

    public String getContentId() {
        return this.contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public VideoMetadata getVideoMetadata() {
        return this.metadata;
    }

    public void setMetadata(VideoMetadata metadata) {
        this.metadata = metadata;
    }

    public ArrayList<Thumbnail> getThumbnailArrayList() {
        return thumbnailList;
    }

    public void setThumbnailArrayList(ArrayList<Thumbnail> thumbnailArrayList) {
        this.thumbnailList = thumbnailArrayList;
    }
}
