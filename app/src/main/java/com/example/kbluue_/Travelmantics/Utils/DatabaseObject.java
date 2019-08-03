package com.example.kbluue_.Travelmantics.Utils;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class DatabaseObject {

    private final String id;
    protected String path;

    public DatabaseObject(){
        id = DatabaseUtils.getKey(path);
    }

    public DatabaseObject(String path){
        this.path = path;
        id = DatabaseUtils.getKey(path);
    }

    public String getId() {
        return id;
    }

    public boolean save() {
        DatabaseUtils.save(id, path, this);
        return false;
    }
}
