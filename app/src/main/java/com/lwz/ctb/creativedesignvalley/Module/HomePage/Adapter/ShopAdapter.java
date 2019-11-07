package com.lwz.ctb.creativedesignvalley.Module.HomePage.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lwz.ctb.creativedesignvalley.Module.HomePage.Bean.Shop;
import com.lwz.ctb.creativedesignvalley.R;
import com.lwz.ctb.creativedesignvalley.Util.ScreenUtil;

import java.util.List;

/**
 * Created by 林伟洲-软件工程 on 2019/11/6.
 */

public class ShopAdapter  extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{
    private Context mContext;
    private List<Shop> mShopList;

    static class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_cover_picture;
        TextView tv_shop_name;
        TextView tv_price;
        public ViewHolder(View View) {
            super(View);

            iv_cover_picture = (ImageView)View.findViewById(R.id.iv_cover_picture);
            tv_shop_name = (TextView) View.findViewById(R.id.tv_shop_name);
            tv_price = (TextView) View.findViewById(R.id.tv_price);
        }
    }

    public ShopAdapter(List<Shop> list, Context context){
        this.mShopList = list ;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item_home_page,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShopAdapter.ViewHolder holder, int position) {
        Shop shop = mShopList.get(position);
        // TODO: 店铺封面图片
//        holder.iv_cover_picture.setImageResource(shop.getCoverPicture());
        holder.tv_shop_name.setText(shop.getShopName());
        holder.tv_price.setText(shop.getPrice());
    }

    @Override
    public int getItemCount() {
        return mShopList.size();
    }

}