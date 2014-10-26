package gui.menus;

import gui.mainclasses.workspace.WorkspaceManager;
import javafx.scene.control.MenuBar;


/**
 * Class instantiates the menu-bar items
 *
 * @author akyker20, allankiplagat
 *
 */
public class MainMenuInitializer {
    public static MenuBar init (WorkspaceManager workspaceManager) {
        MenuBar mainMenu = new MenuBar();
        mainMenu.getMenus().addAll(new FileMenu(workspaceManager), new HelpMenu());
        return mainMenu;
    }
}
