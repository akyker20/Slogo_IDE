package gui.factories;

import java.util.Map;
import gui.componentdrawers.ComponentInitializer;
import gui.variableslist.WorkspaceVariable;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class WorkspaceVariableFactory extends ObjectFactory {
    
    public static final String PARENT = ComponentInitializer.WORKSPACE_VARIABLES;
    public static final String TYPE = FactoryInitializer.WORKSPACE_VARIABLE_FACTORY;
    
    private ObservableList<WorkspaceVariable> myVariablesList;

    public WorkspaceVariableFactory (String name, ObservableList<WorkspaceVariable> variablesList) {
        super(name);
        myVariablesList = variablesList;
        // TODO Auto-generated constructor stub
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        myVariablesList.add(new WorkspaceVariable(params.get("name"), Double.parseDouble(params.get("value"))));
        
        
        
        return new NullNode();
    }

}
