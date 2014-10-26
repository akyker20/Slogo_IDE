package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.turtlefactory.NullNode;
import gui.nonbuttonfeatures.tableviews.imageindex.ImageIndex;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class ImageIndexFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.BUTTON_HOLDER_DRAWER;
    public static final String TYPE = FactoryBuilder.COLOR_INDEX_FACTORY;
    public static final String FILE = "file";
    public static final String INDEX = "index";

    private ObservableList<ImageIndex> myImageIndexList;

    public ImageIndexFactory(String name, List<ImageIndex> imageIndexList) {
        super(name);
        myImageIndexList = (ObservableList<ImageIndex>) imageIndexList;
    }

    @Override
    public Node[] generateObject(Map<String, String> params) {
        int index = Integer.parseInt(params.get(INDEX));
        File image = new File(params.get(FILE));
        for(ImageIndex imageIndex:myImageIndexList){
            if(imageIndex.getMyIndex() == index) {
                imageIndex.setMyImageFile(image);
                refreshList();
                return new Node[] { new NullNode() };
            }
        }
        myImageIndexList.add(new ImageIndex(index, image));
        return new Node[] { new NullNode() };
    }

    private void refreshList() {
        List<ImageIndex> list = new ArrayList<ImageIndex>();
        for (ImageIndex command : myImageIndexList) {
            list.add(command);
        }
        myImageIndexList.clear();
        myImageIndexList.addAll(list);
    }
}