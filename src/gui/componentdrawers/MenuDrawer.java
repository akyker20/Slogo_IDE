package gui.componentdrawers;

import gui.mainclasses.StageInitializer;


public class MenuDrawer extends ComponentDrawer {

    public static final double MENU_HEIGHT_RATIO = 0.045;

    public MenuDrawer (String name) {
        super(name);
        this.setHeight(StageInitializer.SCREEN_HEIGHT * MENU_HEIGHT_RATIO);
    }
}
