package com.example.lukastq.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    private String aUrl;

    public ArticleLoader(Context context, String url) {
        super(context);
        aUrl = url;
    }

    @Override
    public List<Article> loadInBackground() {
        if (aUrl == null) {
            return null;
        }

        return QueryUtils.fetchArticleData(aUrl);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
