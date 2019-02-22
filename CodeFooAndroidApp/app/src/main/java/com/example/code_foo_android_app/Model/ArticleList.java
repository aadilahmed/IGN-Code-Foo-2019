package com.example.code_foo_android_app.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArticleList {
    @SerializedName("data")
    private ArrayList<Article> articleList;

    public ArrayList<Article> getContentArrayList() {
        return articleList;
    }

    public void setContentArrayList(ArrayList<Article> articleArrayList) {
        this.articleList = articleArrayList;
    }
}
