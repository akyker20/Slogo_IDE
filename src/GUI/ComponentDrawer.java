package GUI;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class ComponentDrawer extends Pane {
    private Group myGroup;
    
    public ComponentDrawer(){
        myGroup = new Group();
    }
    
    public void drawShape(Node node) {
        myGroup.getChildren().add(node);
    }

}
