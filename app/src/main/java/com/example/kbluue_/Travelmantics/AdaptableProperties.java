package com.example.kbluue_.Travelmantics;

public class AdaptableProperties {

    private final Class ofClass;
    private final Object value;
    private final int key;

    public AdaptableProperties(Class ofClass, Object value, int key) {
        this.ofClass = ofClass;
        this.value = value;
        this.key = key;
    }

    public Class ofClass() {
        return ofClass;
    }

    public Object getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }
}
