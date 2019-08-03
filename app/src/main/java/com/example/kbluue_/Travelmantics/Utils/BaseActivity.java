package com.example.kbluue_.Travelmantics.Utils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasButtons, DatabaseUtils {

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean get() {
        return false;
    }

    protected boolean authenticate(){
        return false;
    }
}
