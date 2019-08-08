package com.example.kbluue_.Travelmantics.Utils;

import com.example.kbluue_.Travelmantics.Firebase.DatabaseUtils;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class DatabaseObject {

    private String id, path;

    public DatabaseObject(){
        this(null);
    }

    public DatabaseObject(String path){
        this.path = path;
        id = DatabaseUtils.getKey(path);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void save() {
        DatabaseUtils.save(id, path, this);
    }

    public void delete(){
        DatabaseUtils.delete(id, path);
    }
}
