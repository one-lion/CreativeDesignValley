package com.lwz.ctb.creativedesignvalley.Module.HomePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lwz.ctb.creativedesignvalley.R;


//import scut.carson_ho.searchview.ICallBack;
import com.lwz.ctb.creativedesignvalley.Widget.SearchView;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.bCallBack;
//import scut.carson_ho.searchview.bCallBack;

public class SearchActivity extends AppCompatActivity {

    //初始化搜索框变量
    private SearchView homePagerSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pager_search);

        init();
        setListener();

    }

    private void init(){
        homePagerSearchView=findViewById(R.id.sv_homepager_search); //初始化首页搜索框
    }

    private void setListener(){
        //设置点击搜索按键后的操作
        //通过回调函数
        homePagerSearchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {      //这里的文本就是搜索的内容
                Log.d("首页搜索文本", string);
            }
        });

        //设置点击返回键后的操作，通过回调函数实现
        homePagerSearchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }


}
