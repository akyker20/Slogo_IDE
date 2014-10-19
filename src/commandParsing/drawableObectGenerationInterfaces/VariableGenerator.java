package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.WorkspaceVariableFactory;
import gui.variableslist.WorkspaceVariable;
import java.util.HashMap;
import java.util.Map;
import drawableobject.DrawableObject;

public interface VariableGenerator {
    default public DrawableObject generateDrawableObjectRepresentingVariable(WorkspaceVariable variable){
        String parent = WorkspaceVariableFactory.PARENT;
        String type = WorkspaceVariableFactory.TYPE;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("name", variable.getMyName());
        parameters.put("value", ""+variable.getMyValue());
        
        return new DrawableObject(parent, type, parameters);
    }
}
