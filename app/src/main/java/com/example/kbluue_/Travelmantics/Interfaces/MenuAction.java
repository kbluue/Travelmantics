package com.example.kbluue_.Travelmantics.Interfaces;

public class MenuAction {

    public final int menuId;
    public final Runnable menuAction;

    public MenuAction(int menuId, Runnable menuAction) {
        this.menuId = menuId;
        this.menuAction = menuAction;
    }
}
