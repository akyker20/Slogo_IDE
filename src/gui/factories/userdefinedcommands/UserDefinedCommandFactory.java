package gui.factories.userdefinedcommands;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.ObjectFactory;
import gui.factories.turtlefactory.NullNode;
import gui.mainclasses.FactoryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * Class generates and maintains user DisplayedUserCommand objects 
 * @author akyker20, allankiplagat
 *
 */
public class UserDefinedCommandFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.SIGNIFICANT_COMMANDS_DRAWER;
    public static final String TYPE = FactoryBuilder.USER_DEFINED_COMMAND_FACTORY;

    public static final String NAME = "name";
    public static final String PARAMETERS = "params";
    public static final String CONTENT = "content";

    private ObservableList<DisplayedUserCommand> myUserDefinedCommandsList;

    public UserDefinedCommandFactory (String name, List<DisplayedUserCommand> commandList) {
        super(name);
        myUserDefinedCommandsList = (ObservableList<DisplayedUserCommand>) commandList;
    }

    @Override
    public Node[] generateObject (Map<String, String> paramsMap) {
        String name = paramsMap.get(NAME);
        String params = paramsMap.get(PARAMETERS);
        String content = paramsMap.get(CONTENT);

        for (DisplayedUserCommand command : myUserDefinedCommandsList) {
            if (command.getMyName().equalsIgnoreCase(name)) {
                command.setMyParams(params);
                command.setMyContent(content);
                refreshList();
                return new Node[] { new NullNode() };
            }
        }
        myUserDefinedCommandsList.add(new DisplayedUserCommand(name, params, content));
        return new Node[] { new NullNode() };
    }

    private void refreshList () {
        List<DisplayedUserCommand> list = new ArrayList<DisplayedUserCommand>();
        for (DisplayedUserCommand command : myUserDefinedCommandsList) {
            list.add(command);
        }
        myUserDefinedCommandsList.clear();
        myUserDefinedCommandsList.addAll(list);
    }
}
