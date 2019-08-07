package com.example.kbluue_.Travelmantics.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.kbluue_.Travelmantics.Interfaces.HasMenu;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.TravelDeals.Deal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class ViewDealsActivity extends HasMenu {

    List<Deal> deals = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_deals);
        setMenuID(R.menu.for_view_deals);
    }



    @Override
    public void onBackPressed() {
        //select action
    }
}
