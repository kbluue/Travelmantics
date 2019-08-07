package com.example.kbluue_.Travelmantics.TravelDeals;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbluue_.Travelmantics.Adapter.AdapterUtils;

public class DealViewHolder extends RecyclerView.ViewHolder {

    public DealViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(Deal deal){
        AdapterUtils.bind(itemView, deal);
    }
}
