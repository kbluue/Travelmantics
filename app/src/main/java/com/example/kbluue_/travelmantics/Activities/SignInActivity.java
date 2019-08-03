package com.example.kbluue_.Travelmantics.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class SignInActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_screen);
    }

    @Override
    public void onButtonPressed(View v) {
        int id = v.getId();

        if (id == R.id.sign_in){
            if (authenticate()){
                startActivity(new Intent(this, ViewDealsActivity.class));
            } else {

            }
        } else if (id == R.id.sign_up){
            startActivity(new Intent(this, SignUpActivity.class));
        }
    }
}
