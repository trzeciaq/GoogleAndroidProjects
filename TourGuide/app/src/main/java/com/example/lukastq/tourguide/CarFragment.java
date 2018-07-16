package com.example.lukastq.tourguide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class CarFragment extends Fragment {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_SHORT_DESCRIPTION = "EXTRA_SHORT_DESCRIPTION";
    public static final String EXTRA_LONG_DESCRIPTION = "EXTRA_LONG_DESCRIPTION";
    public static final String EXTRA_PICTURE = "EXTRA_PICTURE";
    public ItemAdapter albumAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_tab, container, false);

        ArrayList<Items> album = new ArrayList<>();
        album.add(new Items(getString(R.string.car_name_alfaromeo), getString(R.string.alfaromeo_shortDesc), getString(R.string.alfaromeo_longDesc), R.drawable.alfaromeo));
        album.add(new Items(getString(R.string.car_name_audi), getString(R.string.audi_shortDesc), getString(R.string.audi_longDesc), R.drawable.audi));
        album.add(new Items(getString(R.string.car_name_bugatti), getString(R.string.bugatti_shortDesc), getString(R.string.bugatti_longDesc), R.drawable.bugatti));
        album.add(new Items(getString(R.string.car_name_jaguar), getString(R.string.jaguar_shortDesc), getString(R.string.jaguar_longDesc), R.drawable.jaguar));
        album.add(new Items(getString(R.string.car_name_lamborghini), getString(R.string.lamborghini_shortDesc), getString(R.string.lamborghini_longDesc), R.drawable.lamborghini));
        album.add(new Items(getString(R.string.car_name_maserati), getString(R.string.maserati_shortDesc), getString(R.string.maserati_longDesc), R.drawable.maserati));
        album.add(new Items(getString(R.string.car_name_porsche), getString(R.string.porsche_shortDesc), getString(R.string.porsche_longDesc), R.drawable.porsche));
        album.add(new Items(getString(R.string.car_name_tesla), getString(R.string.tesla_shortDesc), getString(R.string.tesla_longDesc), R.drawable.tesla));


        albumAdapter = new ItemAdapter(getActivity(), album);

        ListView listView = rootView.findViewById(R.id.listview_albums);

        listView.setAdapter(albumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String currentItemNameString = albumAdapter.getItem(position).getItemName();
                String currentItemShortDescString = albumAdapter.getItem(position).getItemShortDesc();
                String currentItemLongDescString = albumAdapter.getItem(position).getItemLongDesc();

                Intent intent = new Intent(getActivity(), ItemDetails.class);
                intent.putExtra(EXTRA_NAME, currentItemNameString);
                intent.putExtra(EXTRA_SHORT_DESCRIPTION, currentItemShortDescString);
                intent.putExtra(EXTRA_LONG_DESCRIPTION, currentItemLongDescString);

                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                Bitmap b = BitmapFactory.decodeResource(getResources(), albumAdapter.getItem(position).getImageId());
                b.compress(Bitmap.CompressFormat.JPEG, 50, bs);
                intent.putExtra(EXTRA_PICTURE, bs.toByteArray());

                getActivity().startActivity(intent);

            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
