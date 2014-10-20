package gui.menus;

import gui.componentdrawers.TurtleScreenDrawer;
import javafx.scene.control.MenuBar;

public class MainMenuInitializer {
    public static MenuBar init(TurtleScreenDrawer turtleScreen){
        MenuBar mainMenu = new MenuBar();
        mainMenu.getMenus().addAll(new FileMenu(), new EditMenu(), new HelpMenu(turtleScreen));
        return mainMenu;
    }
}
