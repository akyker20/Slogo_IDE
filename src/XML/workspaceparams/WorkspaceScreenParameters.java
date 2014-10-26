package XML.workspaceparams;

import java.util.HashMap;
import java.util.Map;


public class WorkspaceScreenParameters {

    protected Map<String, String> myMap;

    public WorkspaceScreenParameters () {
        myMap = new HashMap<String, String>();
    }

    public void put (String key, String value) {
        myMap.put(key, value);
    }

    public String extractParams (String key) {
        String val = myMap.get(key);
        return val == null ? "" : val;
    }

    public boolean hasParam (String key) {
        return myMap.get(key) != null;
    }
}
