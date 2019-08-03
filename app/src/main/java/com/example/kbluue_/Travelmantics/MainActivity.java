package com.example.kbluue_.Travelmantics;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.Activities.ChooseSignInActivity;
import com.example.kbluue_.Travelmantics.Activities.ViewDealsActivity;
import com.example.kbluue_.Travelmantics.DatabaseObjects.Deals;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Deals("Gwarinpa", "Somewhere in Abuja", 23000).save();

        if (isNew()){
            startActivity(new Intent(this, ChooseSignInActivity.class));
        } else {
            startActivity(new Intent(this, ViewDealsActivity.class));
        }
    }

    private boolean isNew(){
        return true;
    }
}
