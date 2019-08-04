package com.example.kbluue_.Travelmantics.DatabaseObjects;

import com.example.kbluue_.Travelmantics.Utils.DatabaseObject;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class Deal extends DatabaseObject {

    private String location, desc, imgPath;
    private int price;

    public Deal(String location, String desc, int price) {
        super("Deals");
        this.location = location;
        this.desc = desc;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
