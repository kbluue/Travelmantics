package com.example.kbluue_.Travelmantics.Utils;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public interface DatabaseUtils {

    static boolean save(String path, Object object){
        FirebaseDatabase.getInstance()
                .getReference(path == null ? "" : path)
                .push()
                .setValue(object);
        return false;
    }

    boolean get();
}
