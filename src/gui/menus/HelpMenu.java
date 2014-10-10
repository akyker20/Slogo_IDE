package gui.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * Sets up a help menu with several different options. The getting started
 * menu item displays an html page that tells the user 
 * @author Austin Kyker
 *
 */
public class HelpMenu extends Menu {
    public HelpMenu(){
        this.setText("Help");
        
        //use Lambda notation and make these open HTML help pages...
        MenuItem gettingStarted = new MenuItem("Getting Started");
        gettingStarted.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Opening getting started page...");
            }
        });
        MenuItem commandHelp = new MenuItem("Commands");
        commandHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Opening commands help page...");
            }
        });
        this.getItems().addAll(gettingStarted, commandHelp);
    }
}
