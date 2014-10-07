package stateUpdate;

import java.util.LinkedList;
import java.util.Queue;

import stateUpdate.booleanexpressions.BooleanExpression;
import drawableobject.DrawableObject;

public class IfElse implements StateUpdate {

	private String booleanSwitch;
	private Queue<StateUpdate> ifTrue = new LinkedList<>();
	private Queue<StateUpdate> ifFalse = new LinkedList<>();

	public IfElse (String switchStatement, Queue<StateUpdate> trueQueue, Queue<StateUpdate> falseQueue){
		booleanSwitch = switchStatement;
		ifTrue = trueQueue;
		ifFalse = falseQueue;
	}
	
	@Override
	public State processUpdate(State initialState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrawableObject generateDrawableObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
