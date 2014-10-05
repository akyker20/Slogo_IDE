package api.classes;

/**
 * Class represents a parse error (similar to a Null class)
 *
 * @author steve, stanley
 *
 */
public class ParseError implements StateUpdate {

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
        return o instanceof ParseError;
    }

}
