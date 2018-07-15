package com.example.lukastq.tourguide;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class itemDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        String nameDescription = getIntent().getStringExtra(TabFragment1.EXTRA_NAME);
        TextView textViewName = (TextView) findViewById(R.id.item_name);
        textViewName.setText(nameDescription);

        setTitle(nameDescription);

        String shortDescription = getIntent().getStringExtra(TabFragment1.EXTRA_SHORT_DESCRIPTION);
        TextView textViewShortDescription = (TextView) findViewById(R.id.item_shortDesc);
        textViewShortDescription.setText(shortDescription);

        String longDescription = getIntent().getStringExtra(TabFragment1.EXTRA_LONG_DESCRIPTION);
        TextView textViewLongDescription = (TextView) findViewById(R.id.item_longDesc);
        textViewLongDescription.setText(longDescription);

        Bitmap picture = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra
                (TabFragment1.EXTRA_PICTURE), 0, getIntent().getByteArrayExtra(TabFragment1.EXTRA_PICTURE).length);
        ImageView imageViewPicture = (ImageView) findViewById(R.id.item_imageView);
        imageViewPicture.setImageBitmap(picture);

    }
}

