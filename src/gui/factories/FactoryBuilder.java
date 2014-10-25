package gui.factories;


import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.turtlefactory.TurtleFactory;
import gui.factories.turtlefactory.TurtleNodes;
import gui.mainclasses.workspace.WorkspaceDataHolder;

public class FactoryBuilder {

    public static final String LINE_FACTORY = "LineFactory";
    public static final String TURTLE_FACTORY = "TurtleFactory";
    public static final String ERROR_FACTORY = "ErrorFactory";
    public static final String CLEAR_GRID_FACTORY = "ClearGridFactory";
    public static final String WORKSPACE_VARIABLE_FACTORY = "WorkspaceVariableFactory";
    public static final String WORKSPACE_COMMAND_FACTORY = "WorkspaceCommandFactory";
    public static final String SCREEN_COLOR_FACTORY = "ScreenColorFactory";

    /**
     * Makes the object factories
     * @return an array of object factories
     */
    public static ObjectFactory[] init (WorkspaceDataHolder holder, TurtleScreenDrawer drawer,
                                        TurtleNodes turtleNodes) {
        return new ObjectFactory[] {
                                    new LineFactory(LINE_FACTORY),
                                    new TurtleFactory(TURTLE_FACTORY, turtleNodes),
                                    new ErrorFactory(ERROR_FACTORY),
                                    new EmptyPaneFactory(CLEAR_GRID_FACTORY, drawer),
                                    new WorkspaceVariableFactory(WORKSPACE_VARIABLE_FACTORY, holder.getMyVariablesList()),
                                    new UserDefinedCommandFactory(WORKSPACE_COMMAND_FACTORY, holder.getMyUserDefinedCommandList()),
        };
    }

}
