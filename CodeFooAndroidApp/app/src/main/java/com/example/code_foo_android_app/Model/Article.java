package com.example.code_foo_android_app.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Article {
    @SerializedName("contentId")
    private String contentId;
    @SerializedName("contentType")
    private String contentType;
    @SerializedName("metadata")
    private Metadata metadata;
    @SerializedName("thumbnails")
    private ArrayList<Thumbnail> thumbnailList;
    @SerializedName("tags")
    private ArrayList<String> tags;
    @SerializedName("authors")
    private ArrayList<String> authors;

    private int numComments;

    public Article(String contentId, String contentType, Metadata metadata,
                   ArrayList<Thumbnail> thumbnails, ArrayList<String> tags,
                   ArrayList<String> authors, int numComments) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.metadata = metadata;
        this.thumbnailList = thumbnails;
        this.tags = tags;
        this.authors = authors;
        this.numComments = numComments;
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

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ArrayList<Thumbnail> getThumbnailArrayList() {
        return thumbnailList;
    }

    public void setThumbnailArrayList(ArrayList<Thumbnail> thumbnailArrayList) {
        this.thumbnailList = thumbnailArrayList;
    }

    public int getNumComments() {
        return this.numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }
}
