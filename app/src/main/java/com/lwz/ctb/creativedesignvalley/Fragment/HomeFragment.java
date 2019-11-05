package com.lwz.ctb.creativedesignvalley.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lwz.ctb.creativedesignvalley.Module.HomePage.SearchActivity;
import com.lwz.ctb.creativedesignvalley.Module.Login.LoginActivity;
import com.lwz.ctb.creativedesignvalley.R;

/**
 * A simple {@link Fragment} subclass.
 */


//这个是首页的碎片
@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment  implements View.OnClickListener{

    private Context context;      //活动实例
    private View homeView;     //首页视图
    private ImageView ivHomeSearch; //搜素框
    private Button btn_login;

    @SuppressLint("ValidFragment")
    public HomeFragment(Context context) {
        // Required empty public constructor
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        homeView=view;

        init();
        setListener();
        return view;
    }

    private void init(){
        ivHomeSearch=homeView.findViewById(R.id.iv_home_search);
        btn_login = homeView.findViewById(R.id.btn_login);
    }

    private void setListener(){
        ivHomeSearch.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_home_search:
                Intent intent=new Intent(context, SearchActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_login:
                Intent loginIntent=new Intent(context, LoginActivity.class);
                startActivity(loginIntent);
                break;

            default:
                break;
        }
    }


}
