package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;
import commandParsing.drawableObectGenerationInterfaces.PaneGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public class ClearScreen extends Home implements PaneGenerator {
    
	private boolean modifiedPen = false;
	
    @Override
    protected double operateOnComponents(List<Double> components,
                                         Queue<DrawableObject> objectQueue)
                                         throws RunTimeDivideByZeroException {
        objectQueue.add(generateDrawableObjectRepresentingPane());
        if(state.isPenDown()){
        	state.togglePenUp();
        	modifiedPen = true;
        }
        double returnValue = super.operateOnComponents(components, objectQueue);
        if(modifiedPen){
        	state.togglePenDown();
        }
        return returnValue;
    }

}
