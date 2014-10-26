package gui.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import gui.componentdrawers.ComponentBuilder;
import gui.factories.turtlefactory.NullNode;
import gui.variableslist.WorkspaceVariable;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class WorkspaceVariableFactory extends ObjectFactory {
    
    public static final String PARENT = ComponentBuilder.WORKSPACE_VARIABLES;
    public static final String TYPE = FactoryBuilder.WORKSPACE_VARIABLE_FACTORY;
    public static final String NAME = "name";
    public static final String VALUE = "value";
    
    private ObservableList<WorkspaceVariable> myVariablesList;

    public WorkspaceVariableFactory (String name, ObservableList<WorkspaceVariable> variablesList) {
        super(name);
        myVariablesList = variablesList;
    }

    @Override
    public Node[] generateObject (Map<String, String> params) {
        String variableName = params.get("name");
        Double variableValue = Double.parseDouble(params.get("value"));
        for(WorkspaceVariable var:myVariablesList){
            if(var.getMyName().equals(variableName)){
                var.setMyValue(variableValue);
                refreshList();
                return new Node[]{new NullNode()};
            }
        }
        myVariablesList.add(new WorkspaceVariable(variableName, variableValue));
        return new Node[]{new NullNode()};
    }

    private void refreshList () {
        List<WorkspaceVariable> list = new ArrayList<WorkspaceVariable>();
        for(WorkspaceVariable var:myVariablesList){
            list.add(var);
        }
        myVariablesList.clear();
        myVariablesList.addAll(list);
        
    }

}
