package com.example.kbluue_.Travelmantics.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.kbluue_.Travelmantics.Interfaces.HasButtons;
import com.example.kbluue_.Travelmantics.MainActivity;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class ChooseSignInActivity extends BaseActivity implements HasButtons {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_sign_in);
    }

    @Override
    public void onButtonPressed(View v) {
        int id = v.getId();

        if (id == R.id.sign_in_email){
            startActivity(new Intent(this, SignInActivity.class));
        } else if (id == R.id.sign_in_google){
            startGoogleAuth();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        //do nothing
    }

    private void startGoogleAuth(){

    }
}
