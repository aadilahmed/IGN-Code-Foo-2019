package com.example.code_foo_android_app.Utils;

import com.example.code_foo_android_app.Model.ContentList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("content")
    Call<ContentList> getContent();
}
