package com.example.code_foo_android_app.Model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("id")
    private String id;
    @SerializedName("count")
    private int count;

    public Comment(String id, int count) {
        this.id = id;
        this.count = count;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
