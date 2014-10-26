package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.turtlefactory.NullNode;
import gui.mainclasses.FactoryBuilder;
import gui.nonbuttonfeatures.tableviews.imageindex.ImageIndex;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * Class implements adding images to be used for the Turtles
 * @author akyker20, allankiplagat
 *
 */
public class ShapePaletteEntryFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.BUTTON_HOLDER_DRAWER;
    public static final String TYPE = FactoryBuilder.SHAPE_PALETTE_INDEX_FACTORY;
    public static final String IMAGE_PATH = "path";
    public static final String INDEX = "index";

    private ObservableList<ImageIndex> myImageIndexList;

    public ShapePaletteEntryFactory (String name, List<ImageIndex> imageIndexList) {
        super(name);
        myImageIndexList = (ObservableList<ImageIndex>) imageIndexList;
    }

    @Override
    public Node[] generateObject (Map<String, String> params) {
        int index = Integer.parseInt(params.get(INDEX));
        File image = new File(params.get(IMAGE_PATH));
        for (ImageIndex imageIndex : myImageIndexList) {
            if (imageIndex.getMyIndex() == index) {
                imageIndex.setMyImageFile(image);
                refreshList();
                return new Node[] { new NullNode() };
            }
        }
        myImageIndexList.add(new ImageIndex(index, image));
        return new Node[] { new NullNode() };
    }

    private void refreshList () {
        List<ImageIndex> list = new ArrayList<ImageIndex>();
        for (ImageIndex command : myImageIndexList) {
            list.add(command);
        }
        myImageIndexList.clear();
        myImageIndexList.addAll(list);
    }
}
