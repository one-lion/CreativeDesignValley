package com.lwz.ctb.creativedesignvalley.Module.HomePage.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lwz.ctb.creativedesignvalley.R;

import java.util.ArrayList;
import java.util.List;

//项目碎片
public class ProjectFragment extends Fragment {
    RecyclerView mRecyclerView;
    private Context context;
    private int mPage;
    public static final String MERCHANT_DETAILS_PAGE = "MERCHANT_DETAILS_PAGE";
    private DemoAdapter mAdapter;

    //这里的数据要设置成我们从网络中获取的数据
    List<String> photoShopData;     //平面设计栏目 数据
    List<String> threeDModelData;   //3D建模栏目 数据
    List<String> wordDesginData;    //文案策划栏目 数据
    List<String> programDesginData; //程序设计栏目  数据

    public static ProjectFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(MERCHANT_DETAILS_PAGE, page);
        ProjectFragment tripFragment = new ProjectFragment();
        tripFragment.setArguments(args);
        return tripFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(MERCHANT_DETAILS_PAGE);
        context = getActivity().getApplicationContext();
        setData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment_recycleview,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_RecyclerView);
        setAdapter();

        return view;
    }

    private void setAdapter(){
        switch (mPage){
            case 0:
                initAdapter(photoShopData);
                break;
            case 1:
                initAdapter(threeDModelData);
                break;
            case 2:
                initAdapter(wordDesginData);
                break;
            case 3:
                initAdapter(programDesginData);
                break;
        }
    }

    //设置数据
    //这里应该要从网络中获取数据，然后放入到List中去
    private void setData(){
        photoShopData = new ArrayList<>();
        for(int i=0; i<15;i++){
            photoShopData.add("平面设计"+i);
        }
        threeDModelData = new ArrayList<>();
        for(int i=0; i<13;i++){
            threeDModelData.add("3D建模"+i);
        }
        wordDesginData = new ArrayList<>();
        for(int i=0; i<15;i++){
            wordDesginData.add("文案策划"+i);
        }
        programDesginData = new ArrayList<>();
        for(int i=0; i<11;i++){
            programDesginData.add("程序设计"+i);
        }
    }
    /**
     * 设置RecyclerView属性
     */
    private void initAdapter(List<String> data) {
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));   //自定义分割线
        //设置瀑布流
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new DemoAdapter(getActivity(), R.layout.homefragment_recycleview_item, data);
        mAdapter.openLoadAnimation();
        mRecyclerView.setAdapter(mAdapter);//设置adapter
        //设置item点击事件
        mAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(),"你好",Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * adapter
     */
    class DemoAdapter extends BaseQuickAdapter<String> {
        int mLayoutId;
        public DemoAdapter(Context context, int LayoutId, List<String> str) {
            super(context, LayoutId, str);
            mLayoutId = LayoutId;
        }

        @Override
        //设置布局中的数据
        public void convert(BaseViewHolder helper, String str) {
            helper.setText(R.id.tvTitle,str);

        }
    }

}
