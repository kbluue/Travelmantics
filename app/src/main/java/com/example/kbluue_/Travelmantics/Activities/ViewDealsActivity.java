package com.example.kbluue_.Travelmantics.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbluue_.Travelmantics.Firebase.AuthUtils;
import com.example.kbluue_.Travelmantics.Firebase.DatabaseUtils;
import com.example.kbluue_.Travelmantics.Firebase.LoginProvider;
import com.example.kbluue_.Travelmantics.Interfaces.HasMenu;
import com.example.kbluue_.Travelmantics.R;
import com.example.kbluue_.Travelmantics.TravelDeals.DealAdapter;
import com.example.kbluue_.Travelmantics.TravelDeals.DealsRetriever;
import com.example.kbluue_.Travelmantics.Utils.BaseActivity;

/**
 * Created by _kbluue_ on 8/2/2019.
 *
 *
 */

public class ViewDealsActivity extends BaseActivity implements HasMenu {

    DealAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_deals);

        initRV();
        loadFirebase();

        if (!AuthUtils.isLoggedIn()){
            AuthUtils.signIn(this,
                    LoginProvider.EMAIL,
                    LoginProvider.PHONE,
                    LoginProvider.GOOGLE);
        }
    }

    @Override
    public void onBackPressed() {
        AuthUtils.signOut(this)
                .addOnCompleteListener(task -> super.onBackPressed());
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

    @Override
    public int setMenuId() {
        return R.menu.for_view_deals;
    }

    @Override
    public SparseArray<Runnable> setMenuActions() {
        Context context = this;
        return new SparseArray<Runnable>(){
            {
                put(R.id.add_new_deal_menu,
                        () -> startActivity(new Intent(context, AddNewDealActivity.class)));

                put(R.id.sign_out_menu,
                        () -> AuthUtils.signOut(context)
                        .addOnCompleteListener(task -> onBackPressed()));
            }
        };
    }
}
