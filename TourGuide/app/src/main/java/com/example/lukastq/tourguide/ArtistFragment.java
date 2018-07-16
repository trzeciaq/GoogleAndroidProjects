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


public class ArtistFragment extends Fragment {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_SHORT_DESCRIPTION = "EXTRA_SHORT_DESCRIPTION";
    public static final String EXTRA_LONG_DESCRIPTION = "EXTRA_LONG_DESCRIPTION";
    public static final String EXTRA_PICTURE = "EXTRA_PICTURE";
    public ItemAdapter albumAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_tab, container, false);

        final ArrayList<Items> album = new ArrayList<>();
        album.add(new Items(getString(R.string.artist_name_metallica), getString(R.string.metallica_shortDesc), getString(R.string.metallica_longDesc), R.drawable.metallica));
        album.add(new Items(getString(R.string.artist_name_acdc), getString(R.string.acdc_shortDesc), getString(R.string.acdc_longDesc), R.drawable.acdc));
        album.add(new Items(getString(R.string.artist_name_aerosmith), getString(R.string.aerosmith_shortDesc), getString(R.string.aerosmith_longDesc), R.drawable.aerosmith));
        album.add(new Items(getString(R.string.artist_name_linkingpark), getString(R.string.linkingpark_shortDesc), getString(R.string.linkingpark_longDesc), R.drawable.linkingpark));
        album.add(new Items(getString(R.string.artist_name_redchotchilipeppers), getString(R.string.redchotchilipeppers_shortDesc), getString(R.string.redchotchilipeppers_longDesc), R.drawable.redchotchilipeppers));
        album.add(new Items(getString(R.string.artist_name_lordi), getString(R.string.lordi_shortDesc), getString(R.string.lordi_longDesc), R.drawable.lordi));
        album.add(new Items(getString(R.string.artist_name_evanescence), getString(R.string.evancescence_shortDesc), getString(R.string.evanescence_longDesc), R.drawable.evanescence));


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
