package Control;

import java.util.Queue;
import drawableobject.DrawableObject;

public interface SlogoGraphics {
    Queue<DrawableObject> parseCommandString(String command);
}
