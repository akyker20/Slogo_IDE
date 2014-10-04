package Feature;

import java.io.InputStream;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import GUI.ComponentDrawer;
import GUI.MenuDrawer;

public class HelpFeature extends Button implements Feature {

    public HelpFeature(MenuDrawer parent) {
        this.setText("Help");
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                openHelpDocument();
            }
        });
        parent.drawShape(this);
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
