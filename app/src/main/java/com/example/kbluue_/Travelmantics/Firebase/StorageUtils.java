package com.example.kbluue_.Travelmantics.Firebase;

import android.app.Activity;
import android.net.Uri;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public interface StorageUtils {

    static StorageReference getRef(String path){
        return FirebaseStorage.getInstance()
                .getReference(path == null ? "" : path);
    }

    static UploadTask save(String path, Uri uri, Activity activity){
        return getRef(path).putFile(uri);
    }
}
