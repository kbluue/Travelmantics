package com.example.kbluue_.Travelmantics.Utils;

import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.Interfaces.HasButtons;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasButtons {

    protected int menu_res;

    public BaseActivity(){}

    public BaseActivity(int menu_res) {
        this.menu_res = menu_res;
    }

    protected boolean authenticate(){
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu_res != 0){
            getMenuInflater().inflate(menu_res, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }
}
