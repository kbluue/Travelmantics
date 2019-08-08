package com.example.kbluue_.Travelmantics.Utils;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.Activities.AddNewDealActivity;
import com.example.kbluue_.Travelmantics.R;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            default:
                Toast.makeText(this, "Menu Action not defined", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.save_menu:
                ((AddNewDealActivity)this).saveMenuAction();
                return true;
            case R.id.add_new_deal_menu:
                startActivity(new Intent(this, AddNewDealActivity.class));
                return true;
        }
    }
}
