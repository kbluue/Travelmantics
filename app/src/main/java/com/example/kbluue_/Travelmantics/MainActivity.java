package com.example.kbluue_.Travelmantics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.DatabaseObjects.Deal;
import com.example.kbluue_.Travelmantics.Utils.DatabaseUtils;

import java.util.Set;

import static android.util.Log.wtf;
import static com.example.kbluue_.Travelmantics.R.string.app_name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Set<Deal> deals = DatabaseUtils.getAllObject("", Deal.class);
        wtf(getString(app_name), "MainActivity.onCreate: start" + deals.size());
        Deal[] deals1 = new Deal[deals.size()];
        deals1 = deals.toArray(deals1);
        for (int i = 0; i < deals.size(); i++) {
            wtf(getString(app_name), "MainActivity.onCreate: " + deals1[i]);
            wtf(getString(app_name), "MainActivity.onCreate: " + deals1[i].getDesc());
        }
        wtf(getString(app_name), "MainActivity.onCreate: end");

//        if (isNew()){
//            startActivity(new Intent(this, ChooseSignInActivity.class));
//        } else {
//            startActivity(new Intent(this, ViewDealsActivity.class));
//        }
    }

    private boolean isNew(){
        return true;
    }
}
