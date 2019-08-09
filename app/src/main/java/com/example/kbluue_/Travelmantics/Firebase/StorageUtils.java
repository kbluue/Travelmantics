package com.example.kbluue_.Travelmantics.Firebase;

import android.net.Uri;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public interface StorageUtils {

    static StorageReference getRef(String... path){
        if (path.length > 0){
            StorageReference ref = FirebaseStorage.getInstance()
                    .getReference(verifyPath(path[0]));
            for (int i = 1; i < path.length; i++) {
                ref = ref.child(verifyPath(path[i]));
            }
            return ref;
        } else return getRef(" ");
    }

    static UploadTask save(Uri uri, String... path){
        return getRef(path).putFile(uri);
    }

    static Task delete(String... filepath){
        return getRef(filepath).delete();
    }

    static String verifyPath(String path){
        if (path == null || path.isEmpty()){
            return ".";
        } else {
            return path;
        }
    }
}
