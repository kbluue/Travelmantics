package com.example.kbluue_.Travelmantics.Utils;

import static android.util.Log.wtf;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public class DatabaseObject {

    private final String id, path;

    public DatabaseObject(){
        this(null);
    }

    public DatabaseObject(String path){
        this.path = path;
        id = DatabaseUtils.getKey(path);
        wtf(" ", "DatabaseObject.DatabaseObject: " + id);
    }

    public String getId() {
        return id;
    }

    public void save() {
        DatabaseUtils.save(id, path, this);
    }

    public void delete(){
        DatabaseUtils.delete(id, path);
    }
}
