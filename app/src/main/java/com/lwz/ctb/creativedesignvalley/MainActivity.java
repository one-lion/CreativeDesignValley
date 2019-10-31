package com.lwz.ctb.creativedesignvalley;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lwz.ctb.creativedesignvalley.Adapter.MyMainViewPagerAdapter;
import com.lwz.ctb.creativedesignvalley.Fragment.HomeFragment;
import com.lwz.ctb.creativedesignvalley.Fragment.InformationFragment;
import com.lwz.ctb.creativedesignvalley.Fragment.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainViewPagr;     //主页的ViewPager;
    private TabLayout mainTabLayout;    //主页的导航栏

    private ArrayList<String> tabNameList;  //导航栏标题数据
    private ArrayList<Fragment> fragmentList;   //碎片数组

    //碎片实例
    private HomeFragment homeFragment;  //首页碎片
    private InformationFragment informationFragment;    //消息碎片
    private MyFragment myFragment;  //我的碎片

    private MyMainViewPagerAdapter myMainViewPagerAdapter;  //主页
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @SuppressLint("WrongViewCast")
    private void init() {
        mainTabLayout =findViewById(R.id.tab_main);
        mainViewPagr =findViewById(R.id.vp_main);

        tabNameList=new ArrayList<String>();    //实例化导航栏名字
        tabNameList.add("首页");      //添加导航栏名字
        tabNameList.add("消息");
        tabNameList.add("我的");

        fragmentList=new ArrayList<Fragment>();     //实例化碎片数组

        homeFragment=new HomeFragment(this);    //新建首页碎片对象
        informationFragment=new InformationFragment(this);  //消息 碎片
        myFragment=new MyFragment(this);    //“我的”碎片
        fragmentList.add(homeFragment);     //将首页碎片添加到FragmentList中
        fragmentList.add(informationFragment);
        fragmentList.add(myFragment);

        myMainViewPagerAdapter=new MyMainViewPagerAdapter(getSupportFragmentManager(),fragmentList,tabNameList);    //新建主页适配器

        mainViewPagr.setAdapter(myMainViewPagerAdapter);    //viewPager与适配器相关联
        mainTabLayout.setupWithViewPager(mainViewPagr);

    }

}
