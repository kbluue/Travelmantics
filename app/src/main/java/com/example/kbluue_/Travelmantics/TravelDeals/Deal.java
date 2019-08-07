package com.example.kbluue_.Travelmantics.TravelDeals;

import android.widget.TextView;

import com.example.kbluue_.Travelmantics.Adapter.Adaptable;
import com.example.kbluue_.Travelmantics.Adapter.AdaptableProperties;
import com.example.kbluue_.Travelmantics.Adapter.PropertyDelegate;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.Utils.DatabaseObject;

import java.util.List;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class Deal extends DatabaseObject implements Adaptable {

    private String location, desc, imgPath;
    private int price;

    public Deal(String location, String desc, int price) {
        super("Deals");
        this.location = location;
        this.desc = desc;
        this.price = price;
    }

    public Deal(){}

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

    @Override
    public List<AdaptableProperties> getProperties() {
        return new PropertyDelegate()
                .addProperty(R.id.location, getLocation(), TextView.class)
                .deliver();
    }
}
