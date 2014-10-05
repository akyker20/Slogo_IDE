package gui.features;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.MenuDrawer;
import java.io.InputStream;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HelpFeature extends Button implements Feature {

    public HelpFeature(MenuDrawer parent) {
        this.setText("Help");
        this.setOnAction(event -> openHelpDocument());
        parent.drawShape(this);
    }
 
    private void openHelpDocument() {
        System.out.println("Opened\n");
        //TODO
    }

    @Override
    public void act () {
        // TODO Auto-generated method stub
        
    }

}
