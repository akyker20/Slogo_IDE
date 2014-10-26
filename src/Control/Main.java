package Control;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class starts the application by initializing a slogo control instance.
 * @author Austin Kyker
 *
 */
public class Main extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {
        new SlogoControl(stage);
    }
}
