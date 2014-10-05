package stateUpdate;

import drawableobject.DrawableObject;


public class Move implements StateUpdate {

    private double amountToMove;

    public Move (double amount) {
        amountToMove = amount;
    }

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
        if (!(o instanceof Move)) {
            return false;
        }
        else {
            Move mover = (Move) o;
            return amountToMove == mover.amountToMove;
        }
    }

}
