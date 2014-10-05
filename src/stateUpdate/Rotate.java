/**
 *
 */
package stateUpdate;

import drawableobject.DrawableObject;


/**
 * @author Steve
 *
 */
public class Rotate implements StateUpdate {

    private float amountToRotate;

    public Rotate (float amount) {
        amountToRotate = amount;
    }

    /*
     * (non-Javadoc)
     * 
     * @see stateUpdate.StateUpdate#processUpdate(stateUpdate.State)
     */
    @Override
    public State processUpdate (State initialState) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see stateUpdate.StateUpdate#generateDrawableObject()
     */
    @Override
    public DrawableObject generateDrawableObject () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Rotate)) {
            return false;
        }
        else {
            Rotate rotator = (Rotate) o;
            return amountToRotate == rotator.amountToRotate;
        }
    }

}
