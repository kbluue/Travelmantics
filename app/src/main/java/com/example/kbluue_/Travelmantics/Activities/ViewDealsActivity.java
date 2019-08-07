package com.example.kbluue_.Travelmantics.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.kbluue_.Travelmantics.DatabaseObjects.Deal;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class ViewDealsActivity extends BaseActivity {

    List<Deal> deals = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_deals);
    }

    @Override
    public void onButtonPressed(View v) {
        int id = v.getId();

        if (id == R.id.add_new_deal){
            startActivity(new Intent(this, AddNewDealActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        //select action
    }
}
