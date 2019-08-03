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

    static boolean save(String id, String path, DatabaseObject object){
        Listener listener = new Listener();
        getRef(path).child(id)
                .setValue(object)
        .addOnCompleteListener(listener.getListener());
        return listener.isSuccess();
    }

    static boolean delete(String id, String path){
        getRef(path).child(id)
                .removeValue();
        return false;
    }
}
