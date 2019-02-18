package com.example.code_foo_android_app.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContentList {
    @SerializedName("data")
    private ArrayList<Content> contentList;

    public ArrayList<Content> getContentArrayList() {
        return contentList;
    }

    public void setContentArrayList(ArrayList<Content> contentArrayList) {
        this.contentList = contentArrayList;
    }
}
