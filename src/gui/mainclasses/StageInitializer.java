package gui.mainclasses;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * The purpose of this class is to initialize the stage and add the scene to it,
 * as well as the borderpane that will serve as the major backbone of the GUI.
 *
 * @author Austin Kyker
 *
 */
public class StageInitializer {

    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    public static final String STYLESHEET_PACKAGE = "Stylesheets/";

    public static BorderPane init (Stage stage) {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        Scene scene = new Scene(pane, SCREEN_WIDTH, SCREEN_HEIGHT, Color.CORNSILK);
        scene.getStylesheets().add(STYLESHEET_PACKAGE + "style.css");
        stage.setScene(scene);
        stage.setTitle(TextGenerator.get(TextGenerator.SLOGO));
        stage.setResizable(false);
        stage.show();
        return pane;
    }
}
