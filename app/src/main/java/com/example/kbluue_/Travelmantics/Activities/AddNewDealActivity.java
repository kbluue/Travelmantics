package com.example.kbluue_.Travelmantics.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class AddNewDealActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_deal);
    }

    private boolean saveToDB(){
        return false;
    }
}
