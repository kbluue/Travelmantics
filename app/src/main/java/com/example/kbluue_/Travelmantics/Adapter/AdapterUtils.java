package com.example.kbluue_.Travelmantics.Adapter;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
                Object value = aP.getValue();
                ImageView target = view.findViewById(aP.getKey());
                if (value instanceof Integer){
                    int i = (int) value;
                    target.setImageResource(i);
                } else if (value instanceof Uri){
                    Uri uri = (Uri) value;
                    target.setImageURI(uri);
                } else if (value instanceof String) {
                    String s = (String) value;
                    Picasso.get()
                            .load(s)
                            .into(target);
                }
            }
        }
    }
}
