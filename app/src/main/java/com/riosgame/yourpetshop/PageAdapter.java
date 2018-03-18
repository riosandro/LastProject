package com.riosgame.yourpetshop;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Jose on 3/16/2018.
 */

public class PageAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;
    private TabLayout tabLayout;

     public PageAdapter(FragmentManager fm) {
       super(fm);
    this. fragments = fragments;
}

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch(position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new PerfilFragment();
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return (2);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:

               // return "SECTION 1";
                break;
            case 1:
               // return "SECTION 2";
        }
        return null;
    }

}
