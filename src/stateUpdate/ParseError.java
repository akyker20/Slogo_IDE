package stateUpdate;

import drawableobject.DrawableObject;


public class ParseError implements StateUpdate {

    @Override
    public State processUpdate (State initialState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DrawableObject generateDrawableObject () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean equals (Object o) {
        return o instanceof ParseError;
    }

}
