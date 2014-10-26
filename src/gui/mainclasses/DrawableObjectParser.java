package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.factories.ObjectFactory;
import java.util.Map;
import javafx.scene.Node;
import drawableobject.DrawableObject;


public class DrawableObjectParser {

    public static void parseDrawableObject (DrawableObject object,
                                            Map<String, ComponentDrawer> drawerMap,
                                            ObjectFactory[] factories) {
        ComponentDrawer identifiedDrawer = parseComponentDrawer(object.getParent(), drawerMap);
        Node[] identifiedNodes = parseNodeToDraw(object, factories);
        identifiedDrawer.drawShape(identifiedNodes);
    }

    private static Node[] parseNodeToDraw (DrawableObject object, ObjectFactory[] factories) {
        ObjectFactory identifiedFactory = null;
        for (ObjectFactory myFactory : factories) {
            if (myFactory.toString().equalsIgnoreCase(object.getType())) {
                identifiedFactory = myFactory;
            }
        }

        if (identifiedFactory != null) { return identifiedFactory.generateObject(object
                .getParameters()); }

        // raise an exception
        return null;
    }

    private static ComponentDrawer parseComponentDrawer (String parent,
                                                         Map<String, ComponentDrawer> drawerMap) {
        for (String drawerName : drawerMap.keySet()) {
            if (drawerName.equalsIgnoreCase(parent)) { return drawerMap.get(drawerName); }
        }
        return null;
    }
}
