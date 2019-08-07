package com.example.kbluue_.Travelmantics.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterUtils {

    public static void bind(View view, Object object){
        Context context = view.getContext();
        Toast.makeText(context, "bind called for + " + object, Toast.LENGTH_SHORT).show();
        Adaptable adaptable = (Adaptable) object;
        List<AdaptableProperties> props = adaptable.getProperties();
        for (AdaptableProperties aP : props){
            if (aP.ofClass() == TextView.class){
                Toast.makeText(context, "a TextView for " +  aP.getValue(), Toast.LENGTH_SHORT).show();
                ((TextView)view.
                        findViewById(aP.getKey()))
                        .setText(aP.getValue().toString());
            } else if (aP.ofClass() == ImageView.class){
                ((ImageView)view.
                        findViewById(aP.getKey()))
                        .setImageBitmap((Bitmap)aP.getValue());
            }
        }
    }
}
