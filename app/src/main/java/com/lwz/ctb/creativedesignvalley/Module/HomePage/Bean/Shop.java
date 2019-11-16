package com.lwz.ctb.creativedesignvalley.Module.HomePage.Bean;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by 林伟洲-软件工程 on 2019/11/6.
 */

//店铺信息的序列化信息
public class Shop implements Serializable {
    private String shopPhotoPath;   //图片路径
    private String shopName;        //店铺名字
    private String shopIntroduction;    //店铺简介
    private String shopPrice;   //店铺价格
    private String shopTemperature; //店铺热度

    public String getShopPhotoPath() {
        return shopPhotoPath;
    }

    public void setShopPhotoPath(String shopPhotoPath) {
        this.shopPhotoPath = shopPhotoPath;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopIntroduction() {
        return shopIntroduction;
    }

    public void setShopIntroduction(String shopIntroduction) {
        this.shopIntroduction = shopIntroduction;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopTemperature() {
        return shopTemperature;
    }

    public void setShopTemperature(String shopTemperature) {
        this.shopTemperature = shopTemperature;
    }
}
