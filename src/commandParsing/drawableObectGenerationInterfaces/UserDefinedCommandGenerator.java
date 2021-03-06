package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.userdefinedcommands.UserDefinedCommandFactory;
import java.util.HashMap;
import java.util.Map;
import translator.Translator;
import workspaceState.UserDefinedCommandCollection.Command;
import drawableobject.DrawableObject;

/**
 * This class generates the actual UserDefinedCommand drawableObjects to give to the GUI.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public interface UserDefinedCommandGenerator {

    default public DrawableObject generateDrawableObjectRepresentingCommand (Command command,
                                                                             Translator translator) {
        String parent = UserDefinedCommandFactory.PARENT;
        String type = UserDefinedCommandFactory.TYPE;
        Map<String, String> parameters = new HashMap<String, String>();
        String condensedCommands = translator.reverseTranslate(command.getCommands());
        String condensedParams = translator.reverseTranslate(command.getParameters());

        parameters.put(UserDefinedCommandFactory.NAME, command.getName());
        parameters.put(UserDefinedCommandFactory.CONTENT, condensedCommands);
        parameters.put(UserDefinedCommandFactory.PARAMETERS, condensedParams);
        return new DrawableObject(parent, type, parameters);
    }

}
