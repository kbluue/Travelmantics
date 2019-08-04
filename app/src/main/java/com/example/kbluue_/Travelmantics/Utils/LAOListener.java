package com.example.kbluue_.Travelmantics.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.HashSet;
import java.util.Set;

/**
 * LOA => Load All Object
 */
public class LAOListener implements ChildEventListener {

    private final Set objects;
    private final Class ofClass;

    public LAOListener(Class ofClass) {
        this.ofClass = ofClass;
        objects = new HashSet();
    }

    public Set getObjects() {
        return objects;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        objects.add(dataSnapshot.getValue(ofClass));
        System.out.println("CastxXy: " + objects);
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
}
