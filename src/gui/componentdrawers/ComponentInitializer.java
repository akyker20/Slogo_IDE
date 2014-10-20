package gui.componentdrawers;

import gui.menus.MainMenuInitializer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class ComponentInitializer {

    // Eventually move these to a config file....
    public static final String GRID_DRAWER = "GridDrawer";
    public static final String MENU_DRAWER = "MenuDrawer";
    public static final String COMMAND_LINE_DRAWER = "CommandLineDrawer";
    public static final String BUTTON_HOLDER_DRAWER = "ButtonHolderDrawer";
    public static final String PREVIOUS_COMMANDS = "previousCommandsDrawer";
    public static final String WORKSPACE_VARIABLES = "workspaceVariablesDrawer";
    public static final String SAVED_COMMANDS = "savedCommands";
    public static final String ERROR_DRAWER = "errorDrawer";
    public static final Map<String, ComponentDrawer> DRAWER_MAP = new HashMap<String, ComponentDrawer>();

    private static String[] myLeftContainerElements = new String[]{GRID_DRAWER, PREVIOUS_COMMANDS, COMMAND_LINE_DRAWER, ERROR_DRAWER};
    
    public static Map<String, ComponentDrawer> init (BorderPane pane) throws ParserConfigurationException, SAXException, IOException { 
        DRAWER_MAP.put(GRID_DRAWER,  new TurtleScreenDrawer(GRID_DRAWER));
        DRAWER_MAP.put(BUTTON_HOLDER_DRAWER, new ButtonHolderDrawer(BUTTON_HOLDER_DRAWER));
        DRAWER_MAP.put(COMMAND_LINE_DRAWER, new CommandLineDrawer(COMMAND_LINE_DRAWER));
        DRAWER_MAP.put(PREVIOUS_COMMANDS, new PreviousCommandsDrawer(PREVIOUS_COMMANDS));
        DRAWER_MAP.put(WORKSPACE_VARIABLES, new WorkspaceVariablesDrawer(WORKSPACE_VARIABLES));
        DRAWER_MAP.put(SAVED_COMMANDS, new SavedCommandsDrawer(SAVED_COMMANDS));
        DRAWER_MAP.put(ERROR_DRAWER, new ErrorDrawer(ERROR_DRAWER));
                 
        pane.setTop(MainMenuInitializer.init((TurtleScreenDrawer) DRAWER_MAP.get(GRID_DRAWER),
                                             (SavedCommandsDrawer) DRAWER_MAP.get(SAVED_COMMANDS)));
        
        VBox leftVBox = new VBox(10);
        leftVBox.getStyleClass().add("leftColumn");
        for(int i = 0; i < myLeftContainerElements.length; i ++){
            leftVBox.getChildren().add(DRAWER_MAP.get(myLeftContainerElements[i]));
        }
        pane.setLeft(leftVBox);
        
        VBox rightVBox = new VBox(10);
        rightVBox.setPadding(new Insets(10, 10, 0, 0));
        rightVBox.getChildren().addAll((WorkspaceVariablesDrawer) DRAWER_MAP.get(WORKSPACE_VARIABLES), 
                                       (SavedCommandsDrawer) DRAWER_MAP.get(SAVED_COMMANDS),
                                       (ButtonHolderDrawer) DRAWER_MAP.get(BUTTON_HOLDER_DRAWER));
        pane.setRight(rightVBox);
      
        return DRAWER_MAP;
    }
}
