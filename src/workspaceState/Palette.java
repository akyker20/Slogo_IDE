package workspaceState;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is the Palette class that contains all of the information for each Palette.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public class Palette<T> {
    private Map<Integer, T> palette = new HashMap<Integer, T>();

    public void addToPalette (int ID, T item) {
        palette.put(ID, item);
    }

    public T getFromPalette (int ID) {
        return palette.get(ID);
    }

    public int getIndexFromItem (T item) {
        return getKeysByValue(item).iterator().next();
    }

    @SuppressWarnings("hiding")
    private <T, E> Set<Integer> getKeysByValue (E value) {
        return palette.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(entry -> entry.getKey())
                .collect(Collectors.toSet());
    }
}
