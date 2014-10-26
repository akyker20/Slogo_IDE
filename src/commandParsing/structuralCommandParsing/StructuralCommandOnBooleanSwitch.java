package commandParsing.structuralCommandParsing;

import workspaceState.WorkspaceState;


public abstract class StructuralCommandOnBooleanSwitch extends StructuralCommand {

    public StructuralCommandOnBooleanSwitch (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    protected boolean booleanSwitch;

    protected void evaluateBooleanExpression () {
        booleanSwitch = expressionComponents.get(0) != 0;
    }

}
