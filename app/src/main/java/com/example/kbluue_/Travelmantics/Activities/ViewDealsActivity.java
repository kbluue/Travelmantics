package com.example.kbluue_.Travelmantics.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.TravelDeals.DealAdapter;
import com.example.kbluue_.Travelmantics.TravelDeals.DealsRetriever;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;
import com.example.kbluue_.Travelmantics.Utils.DatabaseUtils;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class ViewDealsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_deals);
        setMenuID(R.menu.for_view_deals);

        loadFirebase();
        initRV();
    }

    @Override
    public void onBackPressed() {
        //select action
    }

    private void initRV(){
        RecyclerView rv = findViewById(R.id.deals_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new DealAdapter());
    }

    private void loadFirebase(){
        DatabaseUtils.getRef("")
                .addChildEventListener(new DealsRetriever(this));
    }
}
