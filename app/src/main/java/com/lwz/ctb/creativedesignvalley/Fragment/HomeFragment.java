package com.lwz.ctb.creativedesignvalley.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hacknife.carouselbanner.Banner;
import com.hacknife.carouselbanner.CoolCarouselBanner;
import com.hacknife.carouselbanner.interfaces.CarouselImageFactory;
import com.hacknife.carouselbanner.interfaces.OnCarouselItemClickListener;
import com.lwz.ctb.creativedesignvalley.Module.HomePage.Adapter.HomeFragmentViewPagerAdapter;
import com.lwz.ctb.creativedesignvalley.Module.HomePage.Bean.Shop;
import com.lwz.ctb.creativedesignvalley.Module.HomePage.Fragment.ProjectFragment;
import com.lwz.ctb.creativedesignvalley.Module.HomePage.SearchActivity;
import com.lwz.ctb.creativedesignvalley.Module.Login.LoginActivity;
import com.lwz.ctb.creativedesignvalley.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//这个是首页的碎片
@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment  implements View.OnClickListener, HomeFragmentViewPagerAdapter.TabPagerListener{

    private Context context;        // 活动实例
    private View homeView;          // 首页视图
    private ImageView ivHomeSearch; // 搜素框
    private Button btnLogin;        // 登录按钮
    private CoolCarouselBanner banner;  // 广告banner

    //private List<Shop> shops;           // “平面设计”栏目的商店数据
    private List<String> bannerUrls;   // 广告banner的url数据

    //吸顶相关变量
    private Toolbar toolbar;    //标题栏
    private CollapsingToolbarLayout collapsingToolbar;  //滑动效果的布局
    private TabLayout tabLayout;    //标题栏
    private AppBarLayout appbar;    //吸顶效果布局
    private ViewPager viewpager;   //碎片
    private HomeFragmentViewPagerAdapter homeFragmentViewPagerAdapter;  //ViewPager适配器

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

    private void init() {
        ivHomeSearch = homeView.findViewById(R.id.iv_home_search);
       // btnLogin = homeView.findViewById(R.id.btn_login);
        banner = homeView.findViewById(R.id.bome_banner);

        //initShopsData();    // 初始化shops
        LinearLayoutManager layout = new LinearLayoutManager(context);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);//设置为横向排列
       // ShopAdapter adapter = new ShopAdapter(shops,context);

        //轮播图实现
        Banner.init(new ImageFactory());
        initBannerUrls();   // 初始化bannerUrls数据
        banner.setOnCarouselItemClickListener(new OnCarouselItemClickListener() {
            @Override
            public void onItemClick(int position, String url) {
                Log.i("MainActivity","banner click");
                Toast.makeText(context, url, Toast.LENGTH_LONG).show();
            }
        });
        banner.initBanner(bannerUrls);


        //初始化 吸顶的变量
        //toolbar = (Toolbar) homeView.findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) homeView.findViewById(R.id.home_collapsingToolbar);
        tabLayout = (TabLayout) homeView.findViewById(R.id.home_tabLayout);
        appbar = (AppBarLayout) homeView.findViewById(R.id.home_appbar);
        viewpager = (ViewPager) homeView.findViewById(R.id.home_viewpager);

        collapsingToolbar.setExpandedTitleColor(Color.parseColor("#00ffffff"));//设置还没收缩时状态下字体颜色
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的
        //注意这里一定要是getChildFragmentManager(),要不然碎片中会出现空白
        homeFragmentViewPagerAdapter = new HomeFragmentViewPagerAdapter(getChildFragmentManager(),4, Arrays.asList("平面设计", "3D建模", "文案策划", "程序设计"), context);
        homeFragmentViewPagerAdapter.setListener(this);
        viewpager.setAdapter(homeFragmentViewPagerAdapter); //viewPaer设置适配器
        tabLayout.setupWithViewPager(viewpager);        // tabLayout与ViewPager关联
        tabLayout.setTabMode(TabLayout.MODE_FIXED); //设置TabLayout的模式，MODE_FIXED:固定tabs，并同时显示所有的tabs。
    }

    public Fragment getFragment(int position) {
        return ProjectFragment.newInstance(position);
    }

    private class ImageFactory implements CarouselImageFactory {
        @Override
        public void onLoadFactory(String url, ImageView view) {
            Glide.with(view).load(url).into(view);
        }
    }
    // 初始化bannerUrls数据
    private void initBannerUrls(){
        bannerUrls = new ArrayList<>();
        bannerUrls.add("http://img0.imgtn.bdimg.com/it/u=3596394377,2673732419&fm=26&gp=0.jpg");
        bannerUrls.add("https://img.zcool.cn/community/0118cf5837d75ea801219c77f35e67.jpg");
        bannerUrls.add("https://img.zcool.cn/community/0109f2578883a70000018c1b5aaea8.JPG@1280w_1l_2o_100sh.jpg");
    }

    // 初始化bannerUrls数据
//    private void initShopsData(){
//        shops = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            // TODO: 店铺封面图片
//            // Shop shop = new Shop(Bitmap，"店铺", "价格");
//            Shop shop = new Shop("店铺"+i, "价格");
//            shops.add(shop);
//        }
//    }

    private void setListener(){
        ivHomeSearch.setOnClickListener(this);
//        btnLogin.setOnClickListener(this);
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
