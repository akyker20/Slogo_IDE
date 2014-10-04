package GUI;

import javafx.scene.Node;
import drawableobject.DrawableObject;

public class DrawableObjectParser {
    
    private ComponentDrawer[] myDrawers;
    private ObjectFactory[] myFactories;
    
    public DrawableObjectParser(ComponentDrawer[] drawers, ObjectFactory[] factories){
        myDrawers = drawers;
        myFactories = factories;
    }
    
    
    public void parseDrawableObject(DrawableObject object) {
        ComponentDrawer identifiedDrawer = parseComponentDrawer(object.getParent());
        Node identifiedNode = parseNodeToDraw(object);
        identifiedDrawer.drawShape(identifiedNode);        
    }
    
    
    private Node parseNodeToDraw(DrawableObject object){
        ObjectFactory identifiedFactory = null;
        for(int i = 0; i < myFactories.length; i++){
            if(myFactories[i].toString().equals(object.getType())){
                identifiedFactory = myFactories[i];
            }
        }
        if(identifiedFactory != null){
            return identifiedFactory.drawObject(object.getParameters());
        }
        
        //raise an exception
        return null;
    }
    
    
    private ComponentDrawer parseComponentDrawer(String parent) {
        for(int i = 0; i < myDrawers.length; i++){
            if(myDrawers[i].toString().equals(parent)){
                return myDrawers[i];
            }
        }
        return null;
    }
}
