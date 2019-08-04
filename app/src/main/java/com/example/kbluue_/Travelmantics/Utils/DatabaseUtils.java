package com.example.kbluue_.Travelmantics.Utils;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    static OnCompleteListener getOnCompleteListener(){
        return new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                }
            }
        };
    }

    static void save(String id, String path, DatabaseObject object){
        getRef(path).child(id)
                .setValue(object)
        .addOnCompleteListener(getOnCompleteListener());
    }

    static void delete(String id, String path){
        getRef(path).child(id)
                .removeValue();
    }
}
