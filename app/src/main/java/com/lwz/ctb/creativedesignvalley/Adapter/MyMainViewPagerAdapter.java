package com.lwz.ctb.creativedesignvalley.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyMainViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList;  //存放碎片的数组
    private ArrayList<String> titleArrayList;       //存放导航栏名字的数组


    public MyMainViewPagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> titleArray) {
        super(fm);
        this.titleArrayList=titleArray;
        fragmentArrayList=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titleArrayList.get(position);
    }


}
