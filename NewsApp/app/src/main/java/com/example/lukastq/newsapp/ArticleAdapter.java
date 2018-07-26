package com.example.lukastq.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, List<Article> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        if (convertView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        Article currentArticle = getItem(position);
        TextView sectionTextView = rootView.findViewById(R.id.section_name);

        String articleSection = currentArticle.getSection();
        sectionTextView.setText(articleSection);

        TextView titleTextView = rootView.findViewById(R.id.news_title);
        titleTextView.setText(currentArticle.getTitle());

        TextView dateTextView = rootView.findViewById(R.id.news_date);
        String articleDate = currentArticle.getPublishedDate();
        Date date = formatDate(articleDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String dateString = dateFormat.format(date);
        dateTextView.setText(dateString);

        TextView authorTextView = rootView.findViewById(R.id.contributor);
        authorTextView.setText(currentArticle.getAuthorName());


        return rootView;
    }

    private Date formatDate(String dateString) {

        DateFormat dateFormatted = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormatted.parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


}
