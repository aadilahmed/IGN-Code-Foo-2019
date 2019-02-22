package com.example.code_foo_android_app.Model;

import java.util.ArrayList;

public class VideoMetadata {
    private String title;
    private String description;
    private String publishDate;
    private String slug;
    private String state;
    private ArrayList<String> networks;

    public VideoMetadata(String title, String description, String publishDate, String slug,
                    String state, ArrayList<String> networks) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.slug = slug;
        this.state = state;
        this.networks = networks;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
