package stateUpdate;

import drawableobject.DrawableObject;

public interface StateUpdate {
	
	public State processUpdate(State initialState);
	
	public DrawableObject generateDrawableObject();
}
