package gui.componentdrawers;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.componentdrawers.significantcommands.SignificantCommandsDrawer;
import gui.factories.turtlefactory.TurtleNodes;
import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 * This class is responsible for building all of the components. The
 * components are large areas of the screen that house different
 * components.
 *
 * @author akyker20
 *
 */
public class ComponentBuilder {

    public static final String SCREEN_DRAWER = "ScreenDrawer";
    public static final String MENU_DRAWER = "MenuDrawer";
    public static final String COMMAND_LINE_DRAWER = "CommandLineDrawer";
    public static final String BUTTON_HOLDER_DRAWER = "ButtonHolderDrawer";
    public static final String PREVIOUS_COMMANDS = "previousCommandsDrawer";
    public static final String WORKSPACE_VARIABLES = "workspaceVariablesDrawer";
    public static final String WORKSPACE_COMMANDS = "workspaceCommandDrawer";
    public static final String SIGNIFICANT_COMMANDS_DRAWER = "significantCommandsDrawer";
    public static final String ERROR_DRAWER = "errorDrawer";
    public static final int PADDING = 10;

    private static String[] myLeftContainerElements = new String[] { SCREEN_DRAWER,
                                                                     PREVIOUS_COMMANDS,
                                                                     COMMAND_LINE_DRAWER,
                                                                     ERROR_DRAWER };

    private static String[] myRightContainerElements = new String[] { WORKSPACE_VARIABLES,
                                                                      SIGNIFICANT_COMMANDS_DRAWER,
                                                                      BUTTON_HOLDER_DRAWER };

    public static Map<String, ComponentDrawer> build (BorderPane pane, TurtleNodes turtleNodes) {
        Map<String, ComponentDrawer> drawerMap = createComponentsDrawerMap(turtleNodes);
        buildLeftComponents(pane, drawerMap);
        buildRightComponents(pane, drawerMap);
        return drawerMap;
    }

    /**
     * Adds the components that will be on the right side of the screen to the borderpane.
     *
     * @param pane
     * @param drawerMap
     */
    private static void buildRightComponents (BorderPane pane,
                                              Map<String, ComponentDrawer> drawerMap) {
        VBox rightVBox = new VBox(10);
        rightVBox.setPadding(new Insets(PADDING, PADDING, 0, 0));
        addComponentsToBox(drawerMap, myRightContainerElements, rightVBox);
        pane.setRight(rightVBox);
    }

    /**
     * Adds the components that will be on the left side of the screen to the borderpane.
     *
     * @param pane
     * @param drawerMap
     */
    private static void buildLeftComponents (BorderPane pane, Map<String, ComponentDrawer> drawerMap) {
        VBox leftVBox = new VBox(10);
        leftVBox.getStyleClass().add("leftColumn");
        addComponentsToBox(drawerMap, myLeftContainerElements, leftVBox);
        pane.setLeft(leftVBox);
    }

    /**
     * A helper method to make code DRYer
     *
     * @param drawerMap
     * @param components
     * @param vBox
     */
    private static void addComponentsToBox (Map<String, ComponentDrawer> drawerMap,
                                            String[] components,
                                            VBox vBox) {
        for (String component : components) {
            vBox.getChildren().add(drawerMap.get(component));
        }
    }

    /**
     * Returns a map that maps the name of the component drawer to the component drawer itself.
     *
     * @param turtleNodes
     * @return
     */
    private static Map<String, ComponentDrawer> createComponentsDrawerMap (TurtleNodes turtleNodes) {
        Map<String, ComponentDrawer> drawerMap = new HashMap<String, ComponentDrawer>();

        drawerMap.put(SCREEN_DRAWER, new TurtleScreenDrawer(SCREEN_DRAWER, turtleNodes));
        drawerMap.put(BUTTON_HOLDER_DRAWER, new OptionsHolderDrawer(BUTTON_HOLDER_DRAWER));
        drawerMap.put(COMMAND_LINE_DRAWER, new CommandLineDrawer(COMMAND_LINE_DRAWER));
        drawerMap.put(PREVIOUS_COMMANDS, new PreviousCommandsDrawer(PREVIOUS_COMMANDS));
        drawerMap.put(WORKSPACE_VARIABLES, new WorkspaceVariablesDrawer(WORKSPACE_VARIABLES));
        drawerMap.put(SIGNIFICANT_COMMANDS_DRAWER,
                      new SignificantCommandsDrawer(SIGNIFICANT_COMMANDS_DRAWER));
        drawerMap.put(ERROR_DRAWER, new ErrorDrawer(ERROR_DRAWER));

        return drawerMap;
    }
}
