package com.example.kbluue_.Travelmantics.Adapter;

import java.util.ArrayList;
import java.util.List;

public class PropertyDelegate {

    public static List<AdaptableProperties> properties;

    public PropertyDelegate(){
        properties = new ArrayList<>();
    }

    public PropertyDelegate addProperty(int key, Object value, Class ofClass){
        properties.add(new AdaptableProperties(key, value, ofClass));
        return this;
    }

    public List<AdaptableProperties> deliver(){
        return properties;
    }
}
