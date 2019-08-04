package com.example.kbluue_.Travelmantics.Adapter;

import androidx.annotation.Nullable;

public class AdaptableProperties {

    private final Class ofClass;
    private final Object value;
    private final int key;

    public AdaptableProperties(int key, Object value, Class ofClass) {
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

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null){
            return false;
        }

        AdaptableProperties other = (AdaptableProperties) obj;
        return this.key == other.key
                && this.value.equals(other.value)
                && this.ofClass == other.ofClass;
    }
}
