package gui.menus;

import gui.mainclasses.workspace.WorkspaceManager;
import javafx.scene.control.MenuBar;

public class MainMenuInitializer {
    public static MenuBar init(WorkspaceManager workspaceManager){
        MenuBar mainMenu = new MenuBar();
        mainMenu.getMenus().addAll(new FileMenu(workspaceManager), new HelpMenu());
        return mainMenu;
    }
}
