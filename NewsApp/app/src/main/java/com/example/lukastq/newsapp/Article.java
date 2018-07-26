package com.example.lukastq.newsapp;

public class Article {

    private String aTitle;
    private String aUrl;
    private String aPublishedDate;
    private String aSection;
    private String aAusthorName;


    public Article(String title, String url, String publishedDate, String section, String authorName) {
        aTitle = title;
        aUrl = url;
        aPublishedDate = publishedDate;
        aSection = section;
        aAusthorName = authorName;
    }

    public String getTitle() {
        return aTitle;
    }

    public String getUrl() {
        return aUrl;
    }

    public String getPublishedDate() {
        return aPublishedDate;
    }

    public String getSection() {
        return aSection;
    }

    public String getAuthorName() {
        return aAusthorName;
    }

}
