package com.lwz.ctb.creativedesignvalley.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lwz.ctb.creativedesignvalley.R;

/**
 * A simple {@link Fragment} subclass.
 */


//这个是首页的碎片
@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    private Context context;      //活动实例

    @SuppressLint("ValidFragment")
    public HomeFragment(Context context) {
        // Required empty public constructor
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);


        return view;
    }

}
