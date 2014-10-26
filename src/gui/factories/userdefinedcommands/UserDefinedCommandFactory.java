package gui.factories.userdefinedcommands;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.FactoryBuilder;
import gui.factories.ObjectFactory;
import gui.factories.turtlefactory.NullNode;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class UserDefinedCommandFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.SIGNIFICANT_COMMANDS_DRAWER;
    public static final String TYPE = FactoryBuilder.USER_DEFINED_COMMAND_FACTORY;

    public static final String NAME = "name";
    public static final String PARAMS = "params";
    public static final String CONTENT = "content";

    private ObservableList<DisplayedUserCommand> myUserDefinedCommandsList;

    public UserDefinedCommandFactory(String name, List<DisplayedUserCommand> commandList) {
        super(name);
        myUserDefinedCommandsList = (ObservableList<DisplayedUserCommand>) commandList;
    }

    @Override
    public Node[] generateObject(Map<String, String> params) {
        myUserDefinedCommandsList.add(new DisplayedUserCommand(params.get(NAME), params.get(PARAMS), params.get(CONTENT)));
        return new Node[] { new NullNode() };
    }

    private void refreshList() {
        //		List<WorkspaceCommand> list = new ArrayList<WorkspaceCommand>();
        //		for (WorkspaceCommand command : myCommandsList) {
        //			list.add(command);
        //		}
        //		myCommandsList.clear();
        //		myCommandsList.addAll(list);

    }

}
