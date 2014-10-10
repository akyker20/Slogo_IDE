package gui.componentdrawers;

import java.util.HashMap;
import java.util.Map;
import gui.menus.HelpMenu;
import gui.menus.MainMenuInitializer;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
    public static final String ERROR_POPUP = "errorPopup";

    public static Map<String, ComponentDrawer> init (BorderPane pane) {
        
        // Component initialization
        Map<String, ComponentDrawer> drawerMap = new HashMap<String, ComponentDrawer>();
        drawerMap.put(GRID_DRAWER,  new GridDrawer(GRID_DRAWER));
        drawerMap.put(BUTTON_HOLDER_DRAWER, new ButtonHolderDrawer(BUTTON_HOLDER_DRAWER));
        drawerMap.put(COMMAND_LINE_DRAWER, new CommandLineDrawer(COMMAND_LINE_DRAWER));
        drawerMap.put(PREVIOUS_COMMANDS, new PreviousCommandsDrawer(PREVIOUS_COMMANDS));
        drawerMap.put(WORKSPACE_VARIABLES, new WorkspaceVariablesDrawer(WORKSPACE_VARIABLES));
        drawerMap.put(SAVED_COMMANDS, new SavedCommandsDrawer(SAVED_COMMANDS));
                 
        pane.setTop(MainMenuInitializer.init());
        
        VBox leftVBox = new VBox(10);
        leftVBox.getStyleClass().add("leftColumn");
        leftVBox.getChildren().addAll((GridDrawer) drawerMap.get(GRID_DRAWER), 
                                      (PreviousCommandsDrawer) drawerMap.get(PREVIOUS_COMMANDS),
                                      (CommandLineDrawer) drawerMap.get(COMMAND_LINE_DRAWER));
        pane.setLeft(leftVBox);
        
        VBox rightVBox = new VBox(10);
        rightVBox.setPadding(new Insets(10, 10, 0, 0));
        rightVBox.getChildren().addAll((WorkspaceVariablesDrawer) drawerMap.get(WORKSPACE_VARIABLES), 
                                       (SavedCommandsDrawer) drawerMap.get(SAVED_COMMANDS),
                                       (ButtonHolderDrawer) drawerMap.get(BUTTON_HOLDER_DRAWER));
        pane.setRight(rightVBox);
      
        return drawerMap;
    }
}
