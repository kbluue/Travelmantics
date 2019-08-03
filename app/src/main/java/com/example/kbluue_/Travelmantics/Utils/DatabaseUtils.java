package com.example.kbluue_.Travelmantics.Utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public interface DatabaseUtils {

    static DatabaseReference getRef(String path){
        return FirebaseDatabase.getInstance()
                .getReference(path == null ? "" : path);
    }

    static String getKey(String path){
        return getRef(path).push()
                .getKey();
    }

    static boolean save(String path, Object object){
        getRef(path).push()
                .setValue(object);
        return false;
    }

    static boolean save(String path, String id, Object object){
        getRef(path).child(id)
                .setValue(object);
        return false;
    }

    static boolean delete(String path, String id){
        getRef(path).child(id)
                .removeValue();
        return false;
    }
}
