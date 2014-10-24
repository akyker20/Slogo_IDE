package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import workspace.Turtle;
import workspace.Workspace;
import commandParsing.drawableObectGenerationInterfaces.PaneGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public class ClearScreen extends Home implements PaneGenerator {
    
	public ClearScreen(Workspace someWorkspace) {
		super(someWorkspace);
	}

	private boolean modifiedPen = false;
	
    @Override
    protected double operateOnComponents(List<Double> components,
                                         Queue<DrawableObject> objectQueue)
                                         throws RunTimeDivideByZeroException {
        objectQueue.add(generateDrawableObjectRepresentingPane());
        double returnValue = 0;
        for(Turtle t : workspace.turtles.getActiveTurtles()){
            if(t.pen.isPenDown()){
            	t.pen.togglePenUp();
            	modifiedPen = true;
            }
            returnValue = super.operateOnComponents(components, objectQueue);
            if(modifiedPen){
            	t.pen.togglePenDown();
            }
        }
        return returnValue;
    }

}
