package com.example.kbluue_.Travelmantics.Utils;

import com.google.android.gms.tasks.OnCompleteListener;

public class Listener {

    private boolean success;
    private final OnCompleteListener listener;

    public Listener(){
        success = false;
        listener = task -> {
            if (task.isSuccessful()){
                success = true;
            }
        };
    }

    public OnCompleteListener getListener() {
        success = false;
        return listener;
    }

    public boolean isSuccess() {
        return success;
    }
}
