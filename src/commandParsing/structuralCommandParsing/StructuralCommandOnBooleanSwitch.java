package commandParsing.structuralCommandParsing;

import state.State;


public abstract class StructuralCommandOnBooleanSwitch extends StructuralCommand {

	public StructuralCommandOnBooleanSwitch(State someState) {
		super(someState);
	}

	protected boolean booleanSwitch;
	
	protected void evaluateBooleanExpression(){
		booleanSwitch = expressionComponents.get(0) != 0;
	}

}
