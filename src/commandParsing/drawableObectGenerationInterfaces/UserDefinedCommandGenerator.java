package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.userdefinedcommands.UserDefinedCommandFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import workspaceState.UserDefinedCommandCollection.Command;
import drawableobject.DrawableObject;

public interface UserDefinedCommandGenerator {

    default public DrawableObject generateDrawableObjectRepresentingCommand(Command command) {
        String parent = UserDefinedCommandFactory.PARENT;
        String type = UserDefinedCommandFactory.TYPE;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(UserDefinedCommandFactory.NAME, command.getName());
        String condensedCommands = command.getCommands().stream()
        .collect(Collectors.joining(", "));
        parameters.put(UserDefinedCommandFactory.CONTENT, condensedCommands);
        String condensedParams = command.getParameters().stream()
        .collect(Collectors.joining(", "));
        parameters.put(UserDefinedCommandFactory.PARAMS, condensedParams);
        return new DrawableObject(parent, type, parameters);
    }

}
