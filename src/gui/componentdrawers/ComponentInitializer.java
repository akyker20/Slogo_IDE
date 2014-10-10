package gui.componentdrawers;

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

    public static ComponentDrawer[] init (BorderPane pane) {
        // Component initialization
        GridDrawer gridDrawer = new GridDrawer(GRID_DRAWER);
        ButtonHolderDrawer buttonHolder = new ButtonHolderDrawer(BUTTON_HOLDER_DRAWER);
        MenuDrawer menuDrawer = new MenuDrawer(MENU_DRAWER);
        CommandLineDrawer commandLine = new CommandLineDrawer(COMMAND_LINE_DRAWER);
        PreviousCommandsDrawer previousCommands = new PreviousCommandsDrawer(PREVIOUS_COMMANDS);
        WorkspaceVariablesDrawer workspaceVariables = new WorkspaceVariablesDrawer(WORKSPACE_VARIABLES);
        SavedCommandsDrawer savedCommands = new SavedCommandsDrawer(SAVED_COMMANDS);
                 
        pane.setTop(MainMenuInitializer.init());
        
        VBox leftVBox = new VBox(10);
        leftVBox.setStyle("-fx-padding: 10px");
        leftVBox.getChildren().addAll(gridDrawer, previousCommands, commandLine);
        pane.setLeft(leftVBox);
        
        VBox rightVBox = new VBox(10);
        rightVBox.getChildren().addAll(workspaceVariables, savedCommands, buttonHolder);
        pane.setRight(rightVBox);
        
        ComponentDrawer[] drawers =
                new ComponentDrawer[] {
                                       gridDrawer, buttonHolder, commandLine, 
                                       menuDrawer, previousCommands, workspaceVariables,
                                       savedCommands,
                };

        return drawers;
    }
}
