package com.example.kbluue_.Travelmantics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.DatabaseObjects.Deal;
import com.example.kbluue_.Travelmantics.Utils.DatabaseUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseUtils.getAllObject("", Deal.class);

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
