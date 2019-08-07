package com.example.kbluue_.Travelmantics.TravelDeals;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class DealsRetriever implements ChildEventListener {

    Context context;

    public DealsRetriever(Context context) {
        this.context = context;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        Deal deal = dataSnapshot.getValue(Deal.class);
        DealAdapter.deals
                .add(deal);
        System.out.println(DealAdapter.deals.size() + "thinker");
//        Toast.makeText(context, "New deal added + " + DealAdapter.deals.size(), Toast.LENGTH_SHORT).show();
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
