package com.lwz.ctb.creativedesignvalley.Module.HomePage.Bean;

import android.graphics.Bitmap;

/**
 * Created by 林伟洲-软件工程 on 2019/11/6.
 */

public class Shop {
    private String shopName;
    private String price;
    private Bitmap coverPicture;

    public Shop(String shopName, String price) {
        this.shopName = shopName;
        this.price = price;
    }

    public Shop(String shopName, String price, Bitmap coverPicture) {
        this.shopName = shopName;
        this.price = price;
        this.coverPicture = coverPicture;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCoverPicture(Bitmap coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getShopName() {

        return shopName;
    }

    public String getPrice() {
        return price;
    }

    public Bitmap getCoverPicture() {
        return coverPicture;
    }
}
