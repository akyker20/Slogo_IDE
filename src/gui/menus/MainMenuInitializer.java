package gui.menus;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import gui.componentdrawers.SavedCommandsDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import javafx.scene.control.MenuBar;

public class MainMenuInitializer {
    public static MenuBar init(TurtleScreenDrawer turtleScreen, SavedCommandsDrawer savedCommandsDrawer)
            throws ParserConfigurationException, SAXException, IOException{
        MenuBar mainMenu = new MenuBar();
        mainMenu.getMenus().addAll(new FileMenu(savedCommandsDrawer), new EditMenu(), new HelpMenu(turtleScreen));
        return mainMenu;
    }
}
