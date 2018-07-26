package com.example.lukastq.newsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Article>> {

     // The static url of The Guardian HTTP API REQUEST
    private static final String apiKey = "0b94109c-043e-4837-ad8d-48dedcf8db0a";
    private static final String URL_REQUEST = "https://content.guardianapis.com/search?section=football&order-by=newest&show-tags=contributor&page-size=10&api-key=" + apiKey;

    private static final int ARTICLE_LOADER_ID = 1;

    private ArticleAdapter Adapter;

    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView articlesListView = (ListView) findViewById(R.id.list);
        Adapter = new ArticleAdapter(this, new ArrayList<Article>());
        articlesListView.setAdapter(Adapter);

        emptyTextView = (TextView) findViewById(R.id.empty_view);
        articlesListView.setEmptyView(emptyTextView);

        ConnectivityManager connMgr = (ConnectivityManager)
        getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);
        } else {

            View loadingIndicator = findViewById(R.id.progressBar);
            loadingIndicator.setVisibility(View.GONE);
            emptyTextView.setText(R.string.no_internet_connection);
        }

        articlesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Article currentArticle = Adapter.getItem(position);
                Uri articleUri = Uri.parse(currentArticle.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);
                startActivity(websiteIntent);
            }
        });
    }

    @Override
    public Loader<List<Article>> onCreateLoader(int i, Bundle bundle) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        String numbersArticle = sharedPrefs.getString(
                getString(R.string.settings_min_numbers_of_article_key),
                getString(R.string.settings_min_numbers_of_article_default));

        String sectionName = sharedPrefs.getString(
                getString(R.string.settings_section_key),
                getString(R.string.settings_section_default));


        Uri baseUri = Uri.parse(URL_REQUEST);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("section", sectionName);
        uriBuilder.appendQueryParameter("page-size", numbersArticle);
        uriBuilder.appendQueryParameter("orderby", "time");

        return new ArticleLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> articleList) {

        View progressbar= findViewById(R.id.progressBar);
        progressbar.setVisibility(View.GONE);

        emptyTextView.setText(R.string.no_articles);
        Adapter.clear();

        if (articleList != null && !articleList.isEmpty()) {
            Adapter.addAll(articleList);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        Adapter.clear();
    }

    @Override

    // This method initialize the contents of the Activity's options menu.
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the Options Menu we specified in XML
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}