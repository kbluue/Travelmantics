package com.example.kbluue_.Travelmantics.TravelDeals;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kbluue_.Travelmantics.Adapter.Adaptable;
import com.example.kbluue_.Travelmantics.Adapter.AdaptableProperties;
import com.example.kbluue_.Travelmantics.Adapter.PropertyDelegate;
import com.example.kbluue_.Travelmantics.Firebase.StorageUtils;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.Utils.DatabaseObject;

import java.util.List;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class Deal extends DatabaseObject implements Adaptable {

    private String location, desc, imgPath, price;

    public Deal(String location, String desc, String price) {
        this();
        this.location = location;
        this.desc = desc;
        this.price = price;
    }

    public Deal(){
        super("Deals");
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isValid(){
        return getId() != null && getLocation() != null && getDesc() != null;
    }

    @Override
    public List<AdaptableProperties> getProperties() {
        return new PropertyDelegate()
                .addProperty(R.id.location, getLocation(), TextView.class)
                .addProperty(R.id.desc, getDesc(), TextView.class)
                .addProperty(R.id.price, getPrice(), TextView.class)
                .addProperty(R.id.img, getImgPath(), ImageView.class)
                .deliver();
    }

    @Override
    public void save() {
        if (getImgPath() != null){
            StorageUtils.save(getId(),
                    Uri.parse(getImgPath()))
            .addOnCompleteListener( task -> {
                if (task.isSuccessful()){
                    System.out.println(task.getResult().toString() + " : Download URL");
                }
            });
        }
        super.save();
    }
}
