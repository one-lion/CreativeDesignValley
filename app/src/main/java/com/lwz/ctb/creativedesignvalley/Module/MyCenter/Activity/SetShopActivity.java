package com.lwz.ctb.creativedesignvalley.Module.MyCenter.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.lwz.ctb.creativedesignvalley.R;

import java.util.ArrayList;

public class SetShopActivity extends AppCompatActivity {
    private EditText et_shop_name;              //"店铺名'
    private EditText et_shop_introduction;      //"店铺简介"
    private ImageView iv_shop_photo;            // "店铺封面"
    private Spinner sp_choice_project;          //入驻项目
    private Button btn_previous_one;            //上一步
    private Button btn_shop_sure;               //确定
    private EditText et_price_down;             // 价格上限
    private EditText et_price_up;               //价格下限

    private SpinnerAdapter spinnerAdapter;      // 选择框的适配器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_shop);

        init();
    }

    private void init() {
        et_shop_name=findViewById(R.id.et_shop_name);
        et_shop_introduction=findViewById(R.id.et_shop_introduction);
        iv_shop_photo=findViewById(R.id.iv_shop_photo);
        sp_choice_project=findViewById(R.id.sp_choice_project);
        btn_previous_one=findViewById(R.id.btn_previous_one);
        btn_shop_sure=findViewById(R.id.btn_shop_sure);
        et_price_down=findViewById(R.id.et_price_down);
        et_price_up=findViewById(R.id.et_price_up);

        //初始化“选择框数据”
        ArrayList<String> choiceList=new ArrayList<String>();
        choiceList.add("平面设计");
        choiceList.add("3d建模");
        choiceList.add("程序设计");
        choiceList.add("文案设计");
        spinnerAdapter=new com.lwz.ctb.creativedesignvalley.Module.MyCenter.Adapter.SpinnerAdapter(this,choiceList);
        sp_choice_project.setAdapter(spinnerAdapter);
    }
}





