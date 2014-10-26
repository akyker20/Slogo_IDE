package gui.componentdrawers;

import gui.mainclasses.StageInitializer;
import gui.mainclasses.TextGenerator;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * Class manages the error displaying section of the GUI 
 * @author akyker20, allankiplagat
 *
 */
public class ErrorDrawer extends ComponentDrawer {

    private ListView<Label> myListView;

    public ErrorDrawer (String name) {
        super(name);
        setWidth(StageInitializer.SCREEN_WIDTH * TurtleScreenDrawer.GRID_WIDTH_RATIO);
        super.drawShape(new Label[] { new Label(TextGenerator.get(TextGenerator.ERRORS)) });
    }

    /**
     * Method sets this component drawer's ListView in which errors are displayed
     * @param view
     */
    public void setParentNode (ListView view) {
        myListView = view;
        getChildren().add(myListView);
    }

    @Override
    public void drawShape (Node[] n) {
        Label label = (Label) n[0];
        myListView.getItems().clear();
        myListView.getItems().add(label);
    }

}
