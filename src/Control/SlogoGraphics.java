package Control;

import java.io.IOException;
import java.util.Queue;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;



/**
 * Class defines methods accessible to the GUIController
 *
 * @author akyker20, allankiplagat
 *
 */
public interface SlogoGraphics {

    /**
     * Methods delivers a String command to the back-end to be parsed into
     * a Queue of DrawableObjects that can be translated in to shapes that are displayed
     * on the screen
     *
     * @param command
     * @return
     * @throws IOException 
     * @throws RunTimeNullPointerException 
     * @throws RunTimeDivideByZeroException 
     * @throws CompileTimeParsingException 
     */

    Queue<DrawableObject> parseCommandString (String command) throws IOException, CompileTimeParsingException, 
    RunTimeDivideByZeroException, RunTimeNullPointerException;

}
