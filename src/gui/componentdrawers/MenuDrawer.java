package gui.componentdrawers;

import gui.mainclasses.StageInitializer;


public class MenuDrawer extends ComponentDrawer {

    public static final double MENU_HEIGHT_RATIO = 0.1;

    public MenuDrawer (String name) {
        super(name);
        setPrefHeight(StageInitializer.SCREEN_HEIGHT * MENU_HEIGHT_RATIO);
    }
}
