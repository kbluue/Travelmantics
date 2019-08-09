package com.example.kbluue_.Travelmantics.TravelDeals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import static com.example.kbluue_.Travelmantics.TravelDeals.DealAdapter.deals;

public class DealsRetriever implements ChildEventListener {

    DealAdapter context;

    public DealsRetriever(DealAdapter context) {
        this.context = context;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        Deal deal = dataSnapshot.getValue(Deal.class);
        deals.add(deal);
        context.notifyDataSetChanged();
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        Deal deal = dataSnapshot.getValue(Deal.class);
        int index = deals.indexOf(deal);
        deals.set(index, deal);
        context.notifyDataSetChanged();
    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
        Deal deal = getFromSnapshot(dataSnapshot);
        deals.remove(deal);
        context.notifyDataSetChanged();
    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    private Deal getFromSnapshot(DataSnapshot snapshot){
        return snapshot.getValue(Deal.class);
    }
}
