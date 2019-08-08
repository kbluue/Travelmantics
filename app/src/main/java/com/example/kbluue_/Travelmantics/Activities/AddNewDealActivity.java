package com.example.kbluue_.Travelmantics.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.kbluue_.Travelmantics.Firebase.StorageUtils;
import com.example.kbluue_.Travelmantics.Interfaces.HasButtons;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.TravelDeals.Deal;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class AddNewDealActivity extends BaseActivity implements HasButtons {

    Deal deal;
    Uri imgUri;
    private static final int PICTURE_REQ = 462;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_deal);
        setMenuID(R.menu.for_add_deal);

        deal = new Deal();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICTURE_REQ){
            String x = data.getData().toString();
            Uri u = Uri.parse(x);
            StorageUtils.save("deal-images", u, this)
            .addOnSuccessListener(this, taskSnapshot -> Toast.makeText(AddNewDealActivity.this, "win", Toast.LENGTH_SHORT).show());
//            importImg(data.getData());
            Toast.makeText(this, "End", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean saveDeal(){
        if (deal.isValid()){
            deal.save();
            onBackPressed();
        } else {
            Toast.makeText(this, "Nothing to save", Toast.LENGTH_SHORT).show();
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

    public void saveMenuAction(){
        populate();
        saveDeal();
    }

    private void importImg(Uri importUri){
        ImageView view = findViewById(R.id.add_img);
        imgUri = importUri;
        view.setImageURI(imgUri);
    }

    @Override
    public void onButtonPressed(View v) {
        if (v.getId() == R.id.add_img) {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
            startActivityForResult(intent, PICTURE_REQ);
        }
    }
}
