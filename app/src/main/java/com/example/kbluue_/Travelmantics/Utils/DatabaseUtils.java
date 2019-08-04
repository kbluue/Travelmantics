package com.example.kbluue_.Travelmantics.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Set;

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

    static ChildEventListener getEventListener(String path, Class forClass){
        return new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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

    static Set getAllObject(String path, Class objectClass){
        Retriever listener = new Retriever(objectClass);
        DatabaseReference ref = getRef(path);
        ref.addChildEventListener(listener);
        return listener.getObjects();
    }
}
