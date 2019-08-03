package com.example.kbluue_.Travelmantics.Utils;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class DatabaseObject implements DatabaseUtils {

    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean get() {
        return false;
    }
}
