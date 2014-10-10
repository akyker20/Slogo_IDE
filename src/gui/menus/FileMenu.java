package gui.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * Class will be used to load files such as previously saved commands or
 * grid configurations.
 * @author Austin Kyker
 *
 */
public class FileMenu extends Menu {

    public FileMenu(){
        this.setText("File");
        
        //use Lambda notation and make these open HTML help pages...
        MenuItem loadGrid = new MenuItem("Load Grid");
        loadGrid.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Code to open previous grid config...");
            }
        });
        MenuItem loadCommands = new MenuItem("Load Commands");
        loadCommands.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Code to load previously saved commands...");
            }
        });
        MenuItem saveGrid = new MenuItem("Save Grid");
        saveGrid.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Code to save grid configuration...");
            }
        });
        MenuItem saveCommands = new MenuItem("Load Commands");
        saveCommands.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Code to save commands...");
            }
        });
        this.getItems().addAll(loadGrid, loadCommands, saveGrid, saveCommands);
    }
}
