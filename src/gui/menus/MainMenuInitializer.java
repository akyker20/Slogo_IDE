package gui.menus;

import javafx.scene.control.MenuBar;

public class MainMenuInitializer {
    public static MenuBar init(){
        MenuBar mainMenu = new MenuBar();
        mainMenu.getMenus().addAll(new HelpMenu());
        return mainMenu;
    }
}
