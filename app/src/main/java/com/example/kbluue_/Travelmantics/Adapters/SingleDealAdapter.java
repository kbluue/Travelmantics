package com.example.kbluue_.Travelmantics.Adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;

import com.example.kbluue_.Travelmantics.TravelDeals.Deal;
import com.example.kbluue_.Travelmantics.Adapter.AdapterUtils;

import java.util.List;

public class SingleDealAdapter implements ListAdapter {

    private Context context;
    private List<Deal> deals;
    private int resID;

    public SingleDealAdapter(@NonNull Context context, int resource, List<Deal> deals) {
        this.context = context;
        resID = resource;
        this.deals = deals;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return deals.size();
    }

    @Override
    public Deal getItem(int position) {
        return deals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(resID, parent, false);
        }
        AdapterUtils.bind(convertView, getItem(position));
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return deals.isEmpty();
    }
}
