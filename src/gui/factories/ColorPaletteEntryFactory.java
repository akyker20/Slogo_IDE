package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.turtlefactory.NullNode;
import gui.mainclasses.FactoryBuilder;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndex;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * Class manages displaying of user-saved colors.
 * @author akyker20, allankiplagat
 *
 */
public class ColorPaletteEntryFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.BUTTON_HOLDER_DRAWER;
    public static final String TYPE = FactoryBuilder.COLOR_INDEX_FACTORY;
    public static final String COLOR = "color";
    public static final String INDEX = "index";

    private ObservableList<ColorIndex> myColorIndexList;

    public ColorPaletteEntryFactory (String name, List<ColorIndex> colorIndexList) {
        super(name);
        myColorIndexList = (ObservableList<ColorIndex>) colorIndexList;
    }

    /**
     * Creates a color index object that can be displayed to the user.
     * This object will allow the user to make commands and reference
     * the particular color.
     */
    @Override
    public Node[] generateObject (Map<String, String> params) {
        int index = Integer.parseInt(params.get(INDEX));
        Color color = Color.valueOf(params.get(COLOR));
        for (ColorIndex colorIndex : myColorIndexList) {
            if (colorIndex.getMyIndex() == index) {
                colorIndex.setMyColor(color);
                refreshList();
                return new Node[] { new NullNode() };
            }
        }
        myColorIndexList.add(new ColorIndex(index, color));
        return new Node[] { new NullNode() };
    }

    /**
     * Refreshes the observable list so the changes will be reflected
     * instantaneously in the tableview.
     */
    private void refreshList () {
        List<ColorIndex> list = new ArrayList<ColorIndex>();
        for (ColorIndex command : myColorIndexList) {
            list.add(command);
        }
        myColorIndexList.clear();
        myColorIndexList.addAll(list);
    }
}
