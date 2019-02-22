package com.example.code_foo_android_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.code_foo_android_app.Model.Article;
import com.example.code_foo_android_app.Model.ArticleList;
import com.example.code_foo_android_app.Utils.ApiInterface;
import com.example.code_foo_android_app.Utils.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArticlesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mDividerItemDecoration;
    private Retrofit retrofit;

    public ArticlesFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.articles_fragment, container, false);
        retrofit = RetrofitClientInstance.getRetrofitInstance();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<ArticleList> call = apiInterface.getContent();

        call.enqueue(new Callback<ArticleList>() {
            @Override
            public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                if(!response.isSuccessful()){
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            getResources().getString(R.string.network_error_message),
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

                ArrayList<Article> content = response.body().getContentArrayList();
                ArrayList<Article> articleList = new ArrayList<Article>();

                for(Article i : content) {
                    if(i.getContentType().equals("article")) {
                        articleList.add(i);
                    }
                }

                mRecyclerView = rootView.findViewById(R.id.rv_results_list);
                mRecyclerView.setHasFixedSize(true);
                mAdapter = new ArticleAdapter(articleList);
                mLayoutManager = new LinearLayoutManager(getContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);

                mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                        DividerItemDecoration.VERTICAL);
                mRecyclerView.addItemDecoration(mDividerItemDecoration);
            }

            @Override
            public void onFailure(Call<ArticleList> call, Throwable t) {
                Log.d(getResources().getString(R.string.main_activity_tag), t.getLocalizedMessage());
            }
        });

        return rootView;
    }
}