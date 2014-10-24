package gui.factories;

import gui.commandlist.WorkspaceCommand;
import gui.componentdrawers.ComponentInitializer;
import gui.factories.nodes.NullNode;
import gui.variableslist.WorkspaceVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public class WorkspaceCommandFactory extends ObjectFactory {

	public static final String PARENT = ComponentInitializer.WORKSPACE_COMMANDS;
	public static final String TYPE = FactoryInitializer.WORKSPACE_VARIABLE_FACTORY;

	private ObservableList<WorkspaceCommand> myCommandsList;

	public WorkspaceCommandFactory(String name, ObservableList<WorkspaceCommand> commandList) {
		super(name);
		myCommandsList = commandList;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node[] generateObject(Map<String, String> params) {
		String commandName = params.get("name");
		Double commandValue = Double.parseDouble(params.get("value"));
		for (WorkspaceCommand command : myCommandsList) {
			if (command.getMyName().equals(commandName)) {
				command.setMyValue(commandValue);
				refreshList();
				return new Node[] { new NullNode() };
			}
		}
		myCommandsList.add(new WorkspaceCommand(commandName, commandValue));
		return new Node[] { new NullNode() };
	}

	private void refreshList() {
		List<WorkspaceCommand> list = new ArrayList<WorkspaceCommand>();
		for (WorkspaceCommand command : myCommandsList) {
			list.add(command);
		}
		myCommandsList.clear();
		myCommandsList.addAll(list);

	}

}
