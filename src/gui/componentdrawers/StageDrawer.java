package gui.componentdrawers;

import javafx.scene.Node;

/**
 * Class used to insert elements into the stage e.g. Error messages
 * Not used, but placed here for consistency of DrawableObjects use
 * @author allankiplagat
 *
 */
public class StageDrawer extends ComponentDrawer {

    public StageDrawer (String name) {
        super(name);
    }
    
    @Override
    public void drawShape (Node node) {
        //nothing here
    }
}
