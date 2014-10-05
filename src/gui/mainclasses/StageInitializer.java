package gui.mainclasses;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class StageInitializer {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 400;
    public static final String STYLESHEET_PACKAGE = "Stylesheets/";

    public static BorderPane init (Stage stage) {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, SCREEN_WIDTH, SCREEN_HEIGHT, Color.CORNSILK);
        scene.getStylesheets().add(STYLESHEET_PACKAGE + "style.css");
        stage.setScene(scene);
        stage.setTitle("SLogo");
        stage.show();
        return pane;
    }
}
