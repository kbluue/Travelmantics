package com.example.kbluue_.travelmantics;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBTest {

    public static boolean run(){
        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        DatabaseReference fRef = fdb.getReference();
        fRef.push().setValue("link");
        return false;
    }
}
