package com.example.kbluue_.Travelmantics.Firebase;

import android.net.Uri;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public interface StorageUtils {

    static StorageReference getRef(String path){
        return FirebaseStorage.getInstance()
                .getReference(path == null ? "" : path);
    }

    static UploadTask save(String path, Uri uri){
        return getRef(path).putFile(uri);
    }
}
