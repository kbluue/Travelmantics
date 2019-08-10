package com.example.kbluue_.Travelmantics.TravelDeals;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

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
    private boolean online;

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

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isValid(){
        return !getId().isEmpty() && !getLocation().isEmpty() && !getDesc().isEmpty();
    }

    @Override
    public List<AdaptableProperties> getProperties() {
        return new PropertyDelegate()
                .addProperty(R.id.location, getLocation(), TextView.class)
                .addProperty(R.id.desc, getDesc(), TextView.class)
                .addProperty(R.id.price, getPrice(), TextView.class)
                .addProperty(R.id.img, isOnline() ? getImgPath()
                        : getImgPath() == null ? null
                        : Uri.parse(getImgPath()), ImageView.class)
                .deliver();
    }

    @Override
    public void save() {
        if (getImgPath() != null){
            StorageUtils.save(Uri.parse(getImgPath()), getPath(), getId())
                    .addOnSuccessListener(taskSnapshot -> taskSnapshot.getStorage()
                    .getDownloadUrl()
                    .addOnSuccessListener(uri -> {
                        setImgPath(uri.toString());
                        setOnline(true);
                        super.save();
                    }));
        } else {
            super.save();
        }

    }

    @Override
    public void delete() {
        if (isOnline()){
            StorageUtils.delete(getPath(), getId());
        }
        super.delete();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Deal){
            Deal deal = (Deal) obj;
            return getId().equals(deal.getId());
        } else {
            return super.equals(obj);
        }
    }
}
