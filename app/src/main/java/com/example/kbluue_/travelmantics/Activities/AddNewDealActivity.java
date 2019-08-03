package com.example.kbluue_.Travelmantics.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

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

    @Override
    public void onButtonPressed(View v) {
        int id = v.getId();

        if (id == R.id.save){
            if (saveToDB()){
                onBackPressed();
            } else {

            }
        }
    }

    private boolean saveToDB(){
        return false;
    }
}
