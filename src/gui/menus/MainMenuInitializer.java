package gui.menus;

import gui.componentdrawers.SavedCommandsDrawer;
import gui.componentdrawers.TurtleScreenDrawer;

import java.io.IOException;

import javafx.scene.control.MenuBar;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class MainMenuInitializer {
    public static MenuBar init(TurtleScreenDrawer turtleScreen, SavedCommandsDrawer savedCommandsDrawer)
            throws ParserConfigurationException, SAXException, IOException{
        MenuBar mainMenu = new MenuBar();
        mainMenu.getMenus().addAll(new FileMenu(savedCommandsDrawer), new EditMenu(), new HelpMenu(turtleScreen));
        return mainMenu;
    }
}
