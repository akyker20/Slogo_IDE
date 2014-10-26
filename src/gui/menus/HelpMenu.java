package gui.menus;

import gui.mainclasses.TextGenerator;
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
 * menu item displays an HTML page that tells the user
 *
 * @author Austin Kyker
 *
 */
public class HelpMenu extends Menu {

    public static final String BASIC_COMMANDS_URL =
            "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
    public static final String EXTENDED_COMMANDS_URL =
            "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands2.php";
    
    public static final int HELP_PAGE_WIDTH = 800;
    public static final int HELP_PAGE_HEIGHT = 600;

    public HelpMenu () {
        setText(TextGenerator.get(TextGenerator.HELP));

        // use Lambda notation and make these open HTML help pages...
        MenuItem gettingStarted = new MenuItem(TextGenerator.get(TextGenerator.GETTING_STARTED));
        gettingStarted.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                System.out.println("Opening getting started page...");
            }
        });
        MenuItem basicCommandHelp = new MenuItem(TextGenerator.get(TextGenerator.BASIC_COMMANDS));
        basicCommandHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                displayHelpPage(BASIC_COMMANDS_URL);
            }
        });

        MenuItem complexCommandHelp =
                new MenuItem(TextGenerator.get(TextGenerator.COMPLEX_COMMANDS));
        complexCommandHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                displayHelpPage(EXTENDED_COMMANDS_URL);
            }
        });

        getItems().addAll(gettingStarted, basicCommandHelp, complexCommandHelp);
    }

    protected void displayHelpPage (String url) {
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, HELP_PAGE_WIDTH, HELP_PAGE_HEIGHT);
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        webEngine.load(url);
        // add the web view to the scene
        root.getChildren().add(browser);
        stage.setScene(scene);
        stage.show();

    }
}
