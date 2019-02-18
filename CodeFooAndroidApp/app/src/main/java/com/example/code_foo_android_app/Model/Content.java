package com.example.code_foo_android_app.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Content{
    @SerializedName("contentId")
    private String contentId;
    @SerializedName("contentType")
    private String contentType;
    @SerializedName("metadata")
    private Metadata metadata;
    @SerializedName("tags")
    private ArrayList<String> tags;
    @SerializedName("authors")
    private ArrayList<String> authors;

    public Content(String contentId, String contentType, Metadata metadata,
                   ArrayList<String> tags, ArrayList<String> authors) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.metadata = metadata;
        this.tags = tags;
        this.authors = authors;
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
}
