package GUI;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class ComponentDrawer extends Pane {
    
    private String name;
    
    public ComponentDrawer(String name){
        
    }
    
    public void drawShape(Node node) {
        this.getChildren().add(node);
    }
    
    public String toString(){
        return name;
    }

}
