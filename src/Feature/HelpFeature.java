package Feature;

import java.io.InputStream;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import GUI.ComponentDrawer;
import GUI.MenuDrawer;

public class HelpFeature implements Feature {

    private MenuDrawer myParentDrawer;
    private InputStream input;

    public HelpFeature(MenuDrawer parent) {
        myParentDrawer = parent;
        Button helpButton = new Button();
        helpButton.setText("Help");
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                openHelpDocument();
            }
        });
        myParentDrawer.drawShape(helpButton);
    }
 
    public void openHelpDocument() {
        System.out.println("Opened\n");
        //TODO
    }

    @Override
    public void act () {
        // TODO Auto-generated method stub
        
    }

}
