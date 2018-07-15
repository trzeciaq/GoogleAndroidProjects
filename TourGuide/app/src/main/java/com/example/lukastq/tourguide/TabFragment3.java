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


public class TabFragment3 extends Fragment {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_SHORT_DESCRIPTION = "EXTRA_SHORT_DESCRIPTION";
    public static final String EXTRA_LONG_DESCRIPTION = "EXTRA_LONG_DESCRIPTION";
    public static final String EXTRA_PICTURE = "EXTRA_PICTURE";
    public FragmentAdapter albumAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_tab3, container, false);

        ArrayList<Album> album = new ArrayList<>();
        album.add(new Album(getString(R.string.people_name_clinton), getString(R.string.clinton_shortDesc), getString(R.string.clinton_longDesc), R.drawable.clinton));
        album.add(new Album(getString(R.string.people_name_dalailama), getString(R.string.dalailama_shortDesc), getString(R.string.dalailama_longDesc), R.drawable.dalailama));
        album.add(new Album(getString(R.string.people_name_einstein), getString(R.string.einstein_shortDesc), getString(R.string.einstein_longDesc), R.drawable.einstein));
        album.add(new Album(getString(R.string.people_name_hussein), getString(R.string.hussein_shortDesc), getString(R.string.hussein_longDesc), R.drawable.hussein));
        album.add(new Album(getString(R.string.people_name_kopernik), getString(R.string.kopernik_shortDesc), getString(R.string.kopernik_longDesc), R.drawable.kopernik));
        album.add(new Album(getString(R.string.people_name_niuton), getString(R.string.niuton_shortDesc), getString(R.string.niuton_longDesc), R.drawable.niuton));
        album.add(new Album(getString(R.string.people_name_obama), getString(R.string.obama_shortDesc), getString(R.string.obama_longDesc), R.drawable.obama));


        albumAdapter = new FragmentAdapter(getActivity(), album);

        ListView listView = rootView.findViewById(R.id.listview_albums);

        listView.setAdapter(albumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String currentItemNameString = albumAdapter.getItem(position).getItemName();
                String currentItemShortDescString = albumAdapter.getItem(position).getItemShortDesc();
                String currentItemLongDescString = albumAdapter.getItem(position).getItemLongDesc();

                Intent intent = new Intent(getActivity(), itemDetails.class);
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
