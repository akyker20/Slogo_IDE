package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import state.State;
import state.Turtle;

import commandParsing.drawableObectGenerationInterfaces.PaneGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;

import drawableobject.DrawableObject;

public class ClearScreen extends Home implements PaneGenerator {
    
	public ClearScreen(State someState) {
		super(someState);
	}

	private boolean modifiedPen = false;
	
    @Override
    protected double operateOnComponents(List<Double> components,
                                         Queue<DrawableObject> objectQueue)
                                         throws RunTimeDivideByZeroException {
        objectQueue.add(generateDrawableObjectRepresentingPane());
        double returnValue = 0;
        for(Turtle t : state.turtles.getActiveTurtles()){
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
