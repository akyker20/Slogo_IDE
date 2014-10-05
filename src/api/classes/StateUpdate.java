package api.classes;

/**
 * Class processes updates to the GUI and generates DrawableObjects to be
 * passed to the GUI
 *
 * @author steven, stanley
 *
 */
public interface StateUpdate {
    /**
     * method takes a State object, and returns an updated State object
     *
     * @param initialState
     * @return
     */
    public State processUpdate (State initialState);

    /**
     * Method generates DrawableObjects to be animated on the GUI
     *
     * @return
     */
    public DrawableObject generateDrawableObject ();
}
