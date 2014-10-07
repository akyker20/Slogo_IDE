package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;



public class Quotient extends MathCommand {

	@Override
	protected float operateOnComponents(List<Float> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		if(components.get(0)==0 | components.get(1)==0){
			throw new RunTimeDivideByZeroException();
		}
		return components.get(0) / components.get(1);
	}

}
