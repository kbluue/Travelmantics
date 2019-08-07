package com.example.kbluue_.Travelmantics.Interfaces;

import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

public abstract class HasMenu extends AppCompatActivity {

    private int menuID;

    /**
     * @param menuID
     *
     * must be called in the onCreate of subclass
     */
    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(menuID, menu);
        return true;
    }
}
