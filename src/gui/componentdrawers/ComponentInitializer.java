package gui.componentdrawers;

import gui.menus.MainMenuInitializer;
import java.util.HashMap;
import java.util.Map;
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
    public static final String STAGE_DRAWER = "stageDrawer";
    public static final Map<String, ComponentDrawer> DRAWER_MAP = new HashMap<String, ComponentDrawer>();

    public static Map<String, ComponentDrawer> init (BorderPane pane) { 
        DRAWER_MAP.put(GRID_DRAWER,  new GridDrawer(GRID_DRAWER));
        DRAWER_MAP.put(BUTTON_HOLDER_DRAWER, new ButtonHolderDrawer(BUTTON_HOLDER_DRAWER));
        DRAWER_MAP.put(COMMAND_LINE_DRAWER, new CommandLineDrawer(COMMAND_LINE_DRAWER));
        DRAWER_MAP.put(PREVIOUS_COMMANDS, new PreviousCommandsDrawer(PREVIOUS_COMMANDS));
        DRAWER_MAP.put(WORKSPACE_VARIABLES, new WorkspaceVariablesDrawer(WORKSPACE_VARIABLES));
        DRAWER_MAP.put(SAVED_COMMANDS, new SavedCommandsDrawer(SAVED_COMMANDS));
        DRAWER_MAP.put(STAGE_DRAWER,new StageDrawer(STAGE_DRAWER));
                 
        pane.setTop(MainMenuInitializer.init());
        
        VBox leftVBox = new VBox(10);
        leftVBox.getStyleClass().add("leftColumn");
        leftVBox.getChildren().addAll((GridDrawer) DRAWER_MAP.get(GRID_DRAWER), 
                                      (PreviousCommandsDrawer) DRAWER_MAP.get(PREVIOUS_COMMANDS),
                                      (CommandLineDrawer) DRAWER_MAP.get(COMMAND_LINE_DRAWER));
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
