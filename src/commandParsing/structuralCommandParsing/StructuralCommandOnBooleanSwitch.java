package commandParsing.structuralCommandParsing;


public abstract class StructuralCommandOnBooleanSwitch extends StructuralCommand {

	protected boolean booleanSwitch;
	
	protected void evaluateBooleanExpression(){
		booleanSwitch = expressionComponents.get(0) != 0;
	}

}
