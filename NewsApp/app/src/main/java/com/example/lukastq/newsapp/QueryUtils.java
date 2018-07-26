package com.example.lukastq.newsapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class QueryUtils {

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();
    private static final int READ_TIMEOUT = 5000;
    private static final int CONNECT_TIMEOUT = 10000;

    private static URL createURL(String stringURL) {
        URL url = null;
        try {
            url = new URL(stringURL);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating url", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(READ_TIMEOUT);
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                output.append(line);
                line = bufferedReader.readLine();
            }
        }
        return output.toString();
    }

    private static List<Article> extractJson(String articlesJson) {
        if (TextUtils.isEmpty(articlesJson)) {
            return null;
        }

        List<Article> articles = new ArrayList<>();
        String section;
        String publicationDate;
        String title;
        String url;
        String authorName;

        try {
            JSONObject rootObject = new JSONObject(articlesJson);
            JSONObject response = rootObject.optJSONObject("response");
            JSONArray jsonArray = response.optJSONArray("results");
            for (int i = 0, arrayLenght = jsonArray.length(); i < arrayLenght; i++) {
                JSONObject article = jsonArray.optJSONObject(i);

                section = article.getString("sectionName");
                publicationDate = article.getString("webPublicationDate");
                title = article.getString("webTitle");
                url = article.optString("webUrl");

                JSONArray tags = article.getJSONArray("tags");
                    if(tags.length() >0){
                        JSONObject tagsAuthor = tags.getJSONObject(0);
                        authorName = "Author: " + tagsAuthor.optString("webTitle");
                    }
                    else
                        authorName = "Author: unknown ";

                if(section.length() == 0){
                    section = "No section name";
                }
                if (publicationDate.length() == 0) {
                    publicationDate = "No publication date";
                }
                if(title.length() == 0){
                    title = "No title";
                }

                articles.add(new Article(title, url, publicationDate, section, authorName));
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem with parsing JSON articles results", e);
        }
        // Return the list of articles
        return articles;
    }

    public static List<Article> fetchArticleData(String requestUrl) {

        URL url = createURL(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem with HTTP request.", e);
        }

        return extractJson(jsonResponse);
    }
}
