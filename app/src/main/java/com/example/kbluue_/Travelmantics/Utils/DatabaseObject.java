package com.example.kbluue_.Travelmantics.Utils;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class DatabaseObject {

    protected String id, path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean save() {
        DatabaseUtils.save(path, this);
        return false;
    }
}
