package com.example.kbluue_.Travelmantics.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbluue_.Travelmantics.Firebase.AuthUtils;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.TravelDeals.DealAdapter;
import com.example.kbluue_.Travelmantics.TravelDeals.DealsRetriever;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;
import com.example.kbluue_.Travelmantics.Firebase.DatabaseUtils;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class ViewDealsActivity extends BaseActivity {

    DealAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_deals);
        setMenuID(R.menu.for_view_deals);

        initRV();
        loadFirebase();
    }

    @Override
    public void onBackPressed() {
        AuthUtils.signOut(this)
        .addOnCompleteListener(task -> System.exit(0));
    }

    private void initRV(){
        adapter = new DealAdapter();
        RecyclerView rv = findViewById(R.id.deals_rv);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadFirebase(){
        DatabaseUtils.getRef("Deals")
                .addChildEventListener(new DealsRetriever(adapter));
    }
}
