package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIInitializer {
    
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 400;
    public static final String STYLESHEET_PACKAGE = "Stylesheets/";
    
    public static void init(Stage stage){
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, SCREEN_WIDTH, SCREEN_HEIGHT, Color.CORNSILK);
        scene.getStylesheets().add(STYLESHEET_PACKAGE+"style.css");
        stage.setScene(scene);
        stage.setTitle("SLogo");
        stage.show();
        
        GridDrawer gridDrawer = new GridDrawer();
        gridDrawer.getStyleClass().add("Gridpane");
        
        System.out.println(gridDrawer.getWidth());
        GridDrawer gridDrawer2 = new GridDrawer();
        gridDrawer2.setStyle("-fx-background-color: BLACK");
        
        pane.setCenter(gridDrawer);
        pane.setLeft(gridDrawer2);
        //pane.setStyle("-fx-background-color: BLACK");
    }
}
