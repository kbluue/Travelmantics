package com.example.kbluue_.Travelmantics.Utils;

import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected int menuRes;

    /**
     * @param menuRes
     *
     * must be called in the onCreate of subclass
     */
    public void setMenuID(int menuRes) {
        this.menuRes = menuRes;
    }

    protected boolean authenticate(){
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuRes != 0){
            getMenuInflater().inflate(menuRes, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }
}
