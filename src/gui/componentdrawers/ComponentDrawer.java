package gui.componentdrawers;

import javafx.scene.Node;
import javafx.scene.layout.Pane;


public abstract class ComponentDrawer extends Pane {

    private String myName;

    public ComponentDrawer (String name) {
        myName = name;
    }

    public void drawShape (Node node) {
        getChildren().add(node);
    }

    public String getName () {
        return myName;
    }

}
