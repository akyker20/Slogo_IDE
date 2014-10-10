package gui.mainclasses;

import java.util.Map;
import gui.componentdrawers.ComponentDrawer;
import gui.factories.ObjectFactory;
import javafx.scene.Node;
import drawableobject.DrawableObject;


public class DrawableObjectParser {

    private Map<String, ComponentDrawer> myDrawersMap;
    private ObjectFactory[] myFactories;

    public DrawableObjectParser (Map<String, ComponentDrawer> map, ObjectFactory[] factories) {
        myDrawersMap = map;
        myFactories = factories;
    }

    public void parseDrawableObject (DrawableObject object) {
        ComponentDrawer identifiedDrawer = parseComponentDrawer(object.getParent());
        Node identifiedNode = parseNodeToDraw(object);
        identifiedDrawer.drawShape(identifiedNode);
    }

    private Node parseNodeToDraw (DrawableObject object) {
        ObjectFactory identifiedFactory = null;
        for (ObjectFactory myFactorie : myFactories) {
            if (myFactorie.toString().equalsIgnoreCase(object.getType())) {
                identifiedFactory = myFactorie;
            }
        }

        if (identifiedFactory != null) { return identifiedFactory.generateObject(object
                .getParameters()); }

        // raise an exception
        return null;
    }

    private ComponentDrawer parseComponentDrawer (String parent) {
        for (String drawerName : myDrawersMap.keySet()) {
            if (drawerName.equalsIgnoreCase(parent)) { return myDrawersMap.get(drawerName); }
        }
        return null;
    }
}
