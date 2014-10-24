package gui.factories;


import gui.commandlist.WorkspaceCommand;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.nodes.TurtleNodes;
import gui.variableslist.WorkspaceVariable;
import javafx.collections.ObservableList;

public class FactoryInitializer {

    // Probably put in a config file eventually
    public static final String LINE_FACTORY = "LineFactory";
    public static final String TURTLE_FACTORY = "TurtleFactory";
    public static final String ERROR_FACTORY = "ErrorFactory";
    public static final String CLEAR_GRID_FACTORY = "ClearGridFactory";
    public static final String WORKSPACE_VARIABLE_FACTORY = "WorkspaceVariableFactory";
    public static final String WORKSPACE_COMMAND_FACTORY = "WorkspaceCommandFactory";

    /**
     * Makes the object factories
     * @return an array of object factories
     */
    public static ObjectFactory[] init (ObservableList<WorkspaceVariable> variableList, ObservableList<WorkspaceCommand> commandList, TurtleScreenDrawer drawer,
                                        TurtleNodes turtleNodes) {
        return new ObjectFactory[] {
                                    new LineFactory(LINE_FACTORY),
                                    new TurtleFactory(TURTLE_FACTORY, turtleNodes),
                                    new ErrorFactory(ERROR_FACTORY),
                                    new EmptyPaneFactory(CLEAR_GRID_FACTORY, drawer),
                                    new WorkspaceVariableFactory(WORKSPACE_VARIABLE_FACTORY, variableList),
                                    new WorkspaceCommandFactory(WORKSPACE_COMMAND_FACTORY, commandList)
        };
    }

}
