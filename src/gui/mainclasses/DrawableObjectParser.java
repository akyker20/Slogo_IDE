package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.factories.ObjectFactory;
import javafx.scene.Node;
import drawableobject.DrawableObject;


public class DrawableObjectParser {

    private ComponentDrawer[] myDrawers;
    private ObjectFactory[] myFactories;

    public DrawableObjectParser (ComponentDrawer[] drawers, ObjectFactory[] factories) {
        System.out.println(drawers == null);
        myDrawers = drawers;
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
        for (ComponentDrawer myDrawer : myDrawers) {
            if (myDrawer.getName().equalsIgnoreCase(parent)) { return myDrawer; }
        }
        return null;
    }
}
