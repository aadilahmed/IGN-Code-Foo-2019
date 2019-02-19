package com.example.code_foo_android_app.Model;

import java.util.ArrayList;

public class Metadata {
    private String headline;
    private String description;
    private String publishDate;
    private String slug;
    private String state;
    private ArrayList<String> networks;

    public Metadata(String headline, String description, String publishDate, String slug,
                    String state, ArrayList<String> networks) {
        this.headline = headline;
        this.description = description;
        this.publishDate = publishDate;
        this.slug = slug;
        this.state = state;
        this.networks = networks;
    }

    public String getHeadline() {
        return this.headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
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
