package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.turtlefactory.NullNode;
import gui.nonbuttonfeatures.tableviews.ColorIndex;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class ColorIndexFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.BUTTON_HOLDER_DRAWER;
    public static final String TYPE = FactoryBuilder.COLOR_INDEX_FACTORY;
    public static final String COLOR = "color";
    public static final String INDEX = "index";

    private ObservableList<ColorIndex> myColorIndexList;

    public ColorIndexFactory(String name, List<ColorIndex> colorIndexList) {
        super(name);
        myColorIndexList = (ObservableList<ColorIndex>) colorIndexList;
    }

    @Override
    public Node[] generateObject(Map<String, String> params) {
        myColorIndexList.add(new ColorIndex(Integer.parseInt(params.get(INDEX)), Color.valueOf(params.get(COLOR))));
        return new Node[] { new NullNode() };
    }

    private void refreshList() {
        List<ColorIndex> list = new ArrayList<ColorIndex>();
        for (ColorIndex command : myColorIndexList) {
            list.add(command);
        }
        myColorIndexList.clear();
        myColorIndexList.addAll(list);

    }

}
