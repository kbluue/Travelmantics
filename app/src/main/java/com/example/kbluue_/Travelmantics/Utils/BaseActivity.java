package com.example.kbluue_.Travelmantics.Utils;

import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.Interfaces.HasMenu;

/**
 * Created by _kbluue_ on 8/2/2019.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private int menuRes;
    private SparseArray<Runnable> menuActions;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this instanceof HasMenu){
            HasMenu menuActivity = (HasMenu) this;
            menuRes = menuActivity.setMenuId();
            menuActions = menuActivity.setMenuActions();
            getMenuInflater().inflate(menuRes, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Runnable action = menuActions.get(item.getItemId());
        if (action != null){
            action.run();
        } else {
            Toast.makeText(this, "Menu action not defined", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
