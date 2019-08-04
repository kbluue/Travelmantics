package com.example.kbluue_.Travelmantics.Utils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.Interfaces.HasButtons;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasButtons {

    protected boolean authenticate(){
        return true;
    }
}
