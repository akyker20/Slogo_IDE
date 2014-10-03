package GUI;

import javafx.scene.Group;

public abstract class ComponentDrawer {
    private Group myGroup;
    
    public ComponentDrawer(){
        myGroup = new Group();
    }
    
    public abstract void drawShape();

}
