package gui.componentdrawers;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class ComponentInitializer {

    // Eventually move these to a config file....
    public static final String GRID_DRAWER = "GridDrawer";
    public static final String MENU_DRAWER = "MenuDrawer";
    public static final String COMMAND_LINE_DRAWER = "CommandLineDrawer";
    public static final String BUTTON_HOLDER_DRAWER = "ButtonHolderDrawer";

    public static ComponentDrawer[] init (BorderPane pane) {
        // Component initialization
        GridDrawer gridDrawer = new GridDrawer(GRID_DRAWER);
        ButtonHolderDrawer buttonHolder = new ButtonHolderDrawer(BUTTON_HOLDER_DRAWER);
        MenuDrawer menuDrawer = new MenuDrawer(MENU_DRAWER);
        CommandLineDrawer commandLine = new CommandLineDrawer(COMMAND_LINE_DRAWER);

        // Add components to screen
        VBox leftVBox = new VBox();
        leftVBox.getChildren().addAll(gridDrawer, commandLine);
        pane.setLeft(leftVBox);
        pane.setRight(buttonHolder);
        pane.setTop(menuDrawer);
        ComponentDrawer[] drawers =
                new ComponentDrawer[] {
                                       gridDrawer, buttonHolder, commandLine, menuDrawer
                };

        return drawers;
    }
}
