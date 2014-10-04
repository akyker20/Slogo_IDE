package GUI;

public class MenuDrawer extends ComponentDrawer {
    
    public static final double MENU_HEIGHT_RATIO = 0.1;
    
    public MenuDrawer(String name) {
        super(name);
        this.setPrefHeight(GUIInitializer.SCREEN_HEIGHT*MENU_HEIGHT_RATIO);
    }
}
