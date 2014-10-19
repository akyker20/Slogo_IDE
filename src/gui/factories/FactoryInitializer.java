package gui.factories;

import gui.variableslist.WorkspaceVariable;
import javafx.collections.ObservableList;

public class FactoryInitializer {

    // Probably put in a config file eventually
    public static final String LINE_FACTORY = "LineFactory";
    public static final String TURTLE_FACTORY = "TurtleFactory";
    public static final String ERROR_FACTORY = "ErrorFactory";
    public static final String CLEAR_GRID_FACTORY = "ClearGridFactory";
    public static final String WORKSPACE_VARIABLE_FACTORY = "WorkspaceVariableFactory";

    /**
     * Makes the object factories
     * @return an array of object factories
     */
    public static ObjectFactory[] init (ObservableList<WorkspaceVariable> variableList) {
        return new ObjectFactory[] {
                                    new LineFactory(LINE_FACTORY),
                                    new TurtleFactory(TURTLE_FACTORY),
                                    new ErrorFactory(ERROR_FACTORY),
                                    new EmptyPaneFactory(CLEAR_GRID_FACTORY),
                                    new WorkspaceVariableFactory(WORKSPACE_VARIABLE_FACTORY, variableList),
        };
    }

}
