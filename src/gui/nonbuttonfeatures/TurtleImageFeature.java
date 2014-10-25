package gui.nonbuttonfeatures;

import static java.nio.file.StandardCopyOption.*;
import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import com.sun.javafx.geom.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;

public class TurtleImageFeature extends VBox {
    public TurtleImageFeature(ButtonHolderDrawer parentDrawer) {
        this.setHeight(parentDrawer.getHeight());
        this.getChildren().add(new Label("Image-drop"));
        this.setStyle("-fx-background-color: green");

        // When a file is dragged over the scene, the background becomes
        // green and a copy message is displayed near the mouse
        this.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                    TurtleImageFeature.this.setStyle("fx-background-color: lightgreen");
                } else {
                    event.consume();
                }
            }
        });


        // Upon exiting, the background of the scene returns to green.
        this.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                TurtleImageFeature.this.setStyle("fx-background-color: green");
            }
        });


        // When a file is actually dropped it is validated to
        // ensure it has the correct name. The controller is 
        // then called to initialize the driving environment.
        this.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    String filePath = null;
                    for (File file:db.getFiles()) {
                        /*
                        File targetFile = new File("./src/gui/factories/nodes/");
                        Files.copy(filePath, targetFile, REPLACE_EXISTING);

                        File xmlFile = null;
                        for(File f:directory.listFiles()){
                            if(f.getAbsolutePath().contains("kogo")){
                                xmlFile = f;
                            }
                        }*/
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
    }
}


