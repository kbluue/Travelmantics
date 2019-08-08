package com.example.kbluue_.Travelmantics.Firebase;

import com.example.kbluue_.Travelmantics.Utils.DatabaseObject;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
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

    static Task save(String id, String path, DatabaseObject object){
        return getRef(path).child(id)
                .setValue(object);
    }

    static Task delete(String id, String path){
        return getRef(path).child(id)
                .removeValue();
    }
}
