package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.nodes.NullNode;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class UserDefinedCommandFactory extends ObjectFactory {

	public static final String PARENT = ComponentBuilder.WORKSPACE_COMMANDS;
	public static final String TYPE = FactoryBuilder.WORKSPACE_VARIABLE_FACTORY;

	private ObservableList<String> myUserDefinedCommandsList;

	public UserDefinedCommandFactory(String name, List<String> commandList) {
		super(name);
		myUserDefinedCommandsList = (ObservableList<String>) commandList;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node[] generateObject(Map<String, String> params) {
//		String commandName = params.get("name");
//		Double commandValue = Double.parseDouble(params.get("value"));
//		for (String command : myUserDefinedCommandsList) {
//			if (command.getMyName().equals(commandName)) {
//				command.setMyValue(commandValue);
//				refreshList();
//				return new Node[] { new NullNode() };
//			}
//		}
//		myCommandsList.add(new WorkspaceCommand(commandName, commandValue));
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
