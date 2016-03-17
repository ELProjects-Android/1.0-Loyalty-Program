package com.example.shashank.storexp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.shashank.storexp.fragments.First_Fragment;
import com.example.shashank.storexp.fragments.Fourth_Fragment;
import com.example.shashank.storexp.fragments.Second_Fragment;
import com.example.shashank.storexp.fragments.Third_Fragment;


public class DemoPagerAdapter extends FragmentPagerAdapter {

    private int pagerCount = 4;


    public DemoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:        return First_Fragment.newInstance(0);
            case 1:        return Second_Fragment.newInstance(1);
            case 2:        return Third_Fragment.newInstance(2);
            case 3:        return Fourth_Fragment.newInstance(3);
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return pagerCount;
    }
}