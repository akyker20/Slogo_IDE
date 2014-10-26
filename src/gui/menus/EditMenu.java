package gui.menus;

import gui.mainclasses.TextGenerator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * Maybe we will add functionality to this...
 * @author Austin Kyker
 *
 */
public class EditMenu extends Menu {
    public EditMenu(){
        this.setText(TextGenerator.get(TextGenerator.EDIT));
        
        //use Lambda notation and make these open HTML help pages...
        MenuItem preferences = new MenuItem(TextGenerator.get(TextGenerator.PREFERENCES));
        preferences.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Code to modify preferences...");
            }
        });
        this.getItems().addAll(preferences);
    }
}
