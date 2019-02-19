package com.example.code_foo_android_app.Model;

public class Thumbnail {
    private String url;
    private String size;
    private int width;
    private int height;

    public Thumbnail(String url, String size, int width, int height) {
        this.url = url;
        this.size = size;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}