package GUI;

import java.util.Map;
import javafx.scene.Node;

public abstract class ObjectFactory {
    
    private String myName;
    
    public ObjectFactory(String name){
        myName = name;
    }
    
    public abstract Node drawObject(Map<String, String> params);
    
    public String toString(){
        return myName;
    }
}
