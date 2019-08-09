package com.example.kbluue_.Travelmantics.Firebase;

import android.app.Activity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public interface AuthUtils {

    int RC_SIGN_IN = 555;

    static void signIn(Activity host){
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        host.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    static boolean isLoggedIn(){
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }
}
