package api.tests;

import api.classes.DrawableObject;
import api.classes.State;
import api.classes.StateUpdate;


public class Move implements StateUpdate {

    public Move (double amount) {
    }

    @Override
    public State processUpdate (State initialState) {
        return null;
    }

    @Override
    public DrawableObject generateDrawableObject () {
        return null;
    }

    @Override
    public boolean equals (Object o) {
        return false;

    }

}
