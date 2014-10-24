package commandParsing.structuralCommandParsing;

import workspace.Workspace;


public abstract class StructuralCommandOnBooleanSwitch extends StructuralCommand {

	public StructuralCommandOnBooleanSwitch(Workspace someWorkspace) {
		super(someWorkspace);
	}

	protected boolean booleanSwitch;
	
	protected void evaluateBooleanExpression(){
		booleanSwitch = expressionComponents.get(0) != 0;
	}

}
