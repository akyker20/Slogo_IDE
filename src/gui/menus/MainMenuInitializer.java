package gui.menus;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.significantcommands.tabs.SavedCommandsTab;
import gui.mainclasses.workspace.Workspace;
import java.io.IOException;
import javafx.scene.control.MenuBar;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class MainMenuInitializer {
    public static MenuBar init()
            throws ParserConfigurationException, SAXException, IOException{
        MenuBar mainMenu = new MenuBar();
        mainMenu.getMenus().addAll(new FileMenu(), new EditMenu(), new HelpMenu());
        return mainMenu;
    }
}
