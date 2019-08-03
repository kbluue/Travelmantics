package com.example.kbluue_.Travelmantics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.Activities.ChooseSignInActivity;
import com.example.kbluue_.Travelmantics.Activities.ViewDealsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
