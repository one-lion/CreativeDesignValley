package com.lwz.ctb.creativedesignvalley.Fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lwz.ctb.creativedesignvalley.Module.MyCenter.Activity.SettledActivity;
import com.lwz.ctb.creativedesignvalley.R;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class MyFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private View myView;    //表示“我的”视图
    private TextView tv_setShop;    //表示“开店”

    @SuppressLint("ValidFragment")
    public MyFragment(Context context) {
        // Required empty public constructor
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.fragment_my, container, false);

        init();
        setLintener();
        return myView;
    }


    private void init(){
        tv_setShop=myView.findViewById(R.id.tv_set_shop);
    }


    private void setLintener() {
        tv_setShop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_set_shop:      //点击开店
                setShopHintDialog();
                break;

                default:
                    break;
        }
    }

    //点击开店后的提示对话框
    private void setShopHintDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("开店协议");
        builder.setMessage("协议1，2，3····");

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("同意", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //跳转到入驻界面
                Intent intent=new Intent(context, SettledActivity.class);
                startActivity(intent);
            }
        });
        builder.show();
    }



}
