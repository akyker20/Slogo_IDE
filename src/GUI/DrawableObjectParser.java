package GUI;

import javafx.scene.Node;
import drawableobject.DrawableObject;

public class DrawableObjectParser {
    
    
    public static void parseDrawableObject(DrawableObject object, ComponentDrawer[] drawers) {
        ComponentDrawer identifiedDrawer = parseComponentDrawer(object.getParent(), drawers);
        Node identifiedNode = parseNodeToDraw(object);
        identifiedDrawer.drawShape(identifiedNode);        
    }
    
    
    public static Node parseNodeToDraw(DrawableObject object){
        return null;
    }
    
    
    public static ComponentDrawer parseComponentDrawer(String parent, ComponentDrawer[] drawers) {
        for(int i = 0; i < drawers.length; i++){
            if(drawers[i].toString().equals(parent)){
                return drawers[i];
            }
        }
        return null;
    }
}
