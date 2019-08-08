package com.example.kbluue_.Travelmantics.Adapter;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterUtils {

    public static void bind(View view, Object object){
        Adaptable adaptable = (Adaptable) object;
        List<AdaptableProperties> props = adaptable.getProperties();
        for (AdaptableProperties aP : props){
            if (aP.ofClass() == TextView.class){
                ((TextView)view.
                        findViewById(aP.getKey()))
                        .setText(aP.getValue().toString());
            } else if (aP.ofClass() == ImageView.class){
                ((ImageView)view.
                        findViewById(aP.getKey()))
                        .setImageURI((Uri) aP.getValue());
            }
        }
    }
}
