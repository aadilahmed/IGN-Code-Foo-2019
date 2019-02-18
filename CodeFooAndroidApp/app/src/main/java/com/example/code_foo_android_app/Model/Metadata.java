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
}
