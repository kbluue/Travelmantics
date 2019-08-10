package com.example.kbluue_.Travelmantics.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.kbluue_.Travelmantics.Interfaces.HasButtons;
import com.example.kbluue_.Travelmantics.Interfaces.HasMenu;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.TravelDeals.Deal;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class AddNewDealActivity extends BaseActivity implements HasButtons, HasMenu {

    Deal deal;
    private static final int PICTURE_REQ = 462;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_deal);

        deal = new Deal();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICTURE_REQ || resultCode == RESULT_OK){
            Uri uri = data.getData();

            deal.setImgPath(uri.toString());
            displayImage(data.getData());
        }
    }

    private boolean saveDeal(){
        if (deal.isValid()){
            deal.save();
            onBackPressed();
        } else {
            Toast.makeText(this, "Add the required information", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void populate(){
        EditText location = findViewById(R.id.add_location);
        EditText price = findViewById(R.id.add_price);
        EditText desc = findViewById(R.id.add_desc);
        deal.setLocation(location.getText().toString());
        deal.setPrice(price.getText().toString());
        deal.setDesc(desc.getText().toString());
    }

    private void displayImage(Uri importUri){
        ImageView view = findViewById(R.id.add_img);
        view.setImageURI(importUri);
    }

    @Override
    public void onButtonPressed(View v) {
        if (v.getId() == R.id.add_img) {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
            startActivityForResult(intent, PICTURE_REQ);
            v.setClickable(false);
        }
    }

    @Override
    public int setMenuId() {
        return R.menu.for_add_deal;
    }

    @Override
    public SparseArray<Runnable> setMenuActions() {
        return new SparseArray<Runnable>(){
            {
                put(R.id.save_menu,
                        () -> {
                            populate();
                            saveDeal();
                        });

                put(R.id.upload_img,
                        () -> onButtonPressed(findViewById(R.id.add_img)));
            }
        };
    }
}
