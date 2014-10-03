package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIInitializer {
    
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 400;
    
    public static void init(Stage stage){
        Group group = new Group();
        Scene scene = new Scene(group, SCREEN_WIDTH, SCREEN_HEIGHT, Color.CORNSILK);
        stage.setScene(scene);
        stage.setTitle("SLogo");
        stage.show();
        GridDrawer gridDrawer = new GridDrawer();
    }
}
