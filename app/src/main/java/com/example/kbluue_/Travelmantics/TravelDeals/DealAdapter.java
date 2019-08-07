package com.example.kbluue_.Travelmantics.TravelDeals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbluue_.Travelmantics.R;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealViewHolder> {

    public static List<Deal> deals = new ArrayList<>();

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.single_deal_view, parent, false);

        return new DealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {
        holder.bind(deals.get(position));
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }
}
