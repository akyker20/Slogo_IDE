package workspaceState;

import gui.variableslist.WorkspaceVariable;
import java.util.HashMap;
import java.util.Map;
import commandParsing.exceptions.RunTimeNullPointerException;


/**
 * This class contains all of the information for the user defined variables, and is where we 
 * edit or modify them. 
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public class UserDefinedVariableCollection {

    public Map<String, WorkspaceVariable> variableMap = new HashMap<String, WorkspaceVariable>();
    public static final WorkspaceVariable defaultVar = new WorkspaceVariable("dummyVar", 0);

    public WorkspaceVariable storeVariable (String name, double value) {
        if (variableMap.containsKey(name)) {
            variableMap.get(name).addValue(-variableMap.get(name).getMyValue() + value);
        }
        else {
            variableMap.put(name, new WorkspaceVariable(name, value));
        }
        return variableMap.get(name);
    }

    public void incrementVariable (String loopVariable, double incrementAmount) {
        variableMap.get(loopVariable).addValue(incrementAmount);
    }

    public double fetchVariable (String name) throws RunTimeNullPointerException {
        if (!variableMap.keySet().contains(name)) { throw new RunTimeNullPointerException(name); }
        return variableMap.get(name).getMyValue();
    }

    public WorkspaceVariable fetchWorkspaceVariable (String name)
            throws RunTimeNullPointerException {
        if (!variableMap.keySet().contains(name)) { throw new RunTimeNullPointerException(name); }
        return variableMap.get(name);
    }

    public boolean variableExists (String name) {
        return variableMap.containsKey(name);
    }
}
