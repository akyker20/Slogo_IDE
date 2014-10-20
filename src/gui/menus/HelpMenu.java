package gui.menus;

import gui.componentdrawers.TurtleScreenDrawer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Sets up a help menu with several different options. The getting started
 * menu item displays an html page that tells the user 
 * @author Austin Kyker
 *
 */
public class HelpMenu extends Menu {
    
    public static final String BASIC_COMMANDS_URL = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
    public static final String EXTENDED_COMMANDS_URL = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands2.php";
    
    public HelpMenu(TurtleScreenDrawer turtleScreen){
        this.setText("Help");
        
        //use Lambda notation and make these open HTML help pages...
        MenuItem gettingStarted = new MenuItem("Getting Started");
        gettingStarted.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Opening getting started page...");
            }
        });
        MenuItem basicCommandHelp = new MenuItem("Basic Commands");
        basicCommandHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               displayHelpPage(BASIC_COMMANDS_URL);
            }
        });
        
        MenuItem complexCommandHelp = new MenuItem("Complex Commands");
        complexCommandHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                displayHelpPage(EXTENDED_COMMANDS_URL);
            }
        });
        
        this.getItems().addAll(gettingStarted, basicCommandHelp, complexCommandHelp);
    }

    protected void displayHelpPage (String url) {
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        webEngine.load(url);
        //add the web view to the scene
        root.getChildren().add(browser);
        stage.setScene(scene);
        stage.show();
        
    }
}
