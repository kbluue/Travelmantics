package com.example.kbluue_.Travelmantics;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kbluue_.Travelmantics.Activities.ViewDealsActivity;
import com.example.kbluue_.Travelmantics.Firebase.AuthUtils;
import com.example.kbluue_.Travelmantics.Firebase.LoginProvider;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.kbluue_.Travelmantics.Firebase.AuthUtils.RC_SIGN_IN;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (AuthUtils.isLoggedIn()){
            startActivity(new Intent(this, ViewDealsActivity.class));
        } else {
            System.out.println("Not logged in");
            AuthUtils.signIn(this,
                    LoginProvider.EMAIL,
                    LoginProvider.PHONE,
                    LoginProvider.GOOGLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ViewDealsActivity.class));
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
