package com.example.kbluue_.Travelmantics.Firebase;

import android.app.Activity;
import android.content.Context;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public interface AuthUtils {

    int RC_SIGN_IN = 555;

    static void signIn(Activity host, LoginProvider defaultProvider, LoginProvider... otherProviders){
        List<AuthUI.IdpConfig> providers = new ArrayList<>();

        providers.add(getConfig(defaultProvider));
        for (LoginProvider provider : otherProviders){
            providers.add(getConfig(provider));
        }

        host.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    static Task<Void> signOut(Context context){
        return AuthUI.getInstance()
                .signOut(context);
    }

    static Task<Void> deleteAccount(Context context){
        return AuthUI.getInstance()
                .delete(context);
    }

    static boolean isLoggedIn(){
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    static AuthUI.IdpConfig getConfig(LoginProvider provider){
        switch (provider){
            case EMAIL: return new AuthUI.IdpConfig.EmailBuilder().build();
            case PHONE: return new AuthUI.IdpConfig.PhoneBuilder().build();
            case GITHUB: return new AuthUI.IdpConfig.GitHubBuilder().build();
            case GOOGLE: return new AuthUI.IdpConfig.GoogleBuilder().build();
            case FACEBOOK: return new AuthUI.IdpConfig.FacebookBuilder().build();
            case TWITTER: return new AuthUI.IdpConfig.TwitterBuilder().build();
            case ANONYMOUS: return new AuthUI.IdpConfig.AnonymousBuilder().build();
            default: return null;
        }
    }
}
