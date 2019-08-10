package com.example.kbluue_.Travelmantics.Interfaces;

import android.util.SparseArray;

public interface HasMenu {

    int setMenuId();

    SparseArray<Runnable> setMenuActions();
}
