package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;
import commandParsing.drawableObectGenerationInterfaces.PaneGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public class ClearScreen extends Home implements PaneGenerator {
    
    @Override
    protected double operateOnComponents(List<Double> components,
                                         Queue<DrawableObject> objectQueue)
                                         throws RunTimeDivideByZeroException {
        objectQueue.add(generateDrawableObjectRepresentingPane());
        return super.operateOnComponents(components, objectQueue);
    }

}
