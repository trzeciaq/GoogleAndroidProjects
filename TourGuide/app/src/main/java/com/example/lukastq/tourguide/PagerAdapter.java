package com.example.lukastq.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ArtistFragment tab1 = new ArtistFragment();
                return tab1;
            case 1:
                CarFragment tab2 = new CarFragment();
                return tab2;
            case 2:
                PeopleFragment tab3 = new PeopleFragment();
                return tab3;
            case 3:
                SuperCarsFragment tab4 = new SuperCarsFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}