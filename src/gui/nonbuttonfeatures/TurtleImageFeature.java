package gui.nonbuttonfeatures;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import static java.nio.file.StandardCopyOption.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TurtleImageFeature extends BorderPane {
    public TurtleImageFeature(OptionsHolderDrawer parentDrawer) {
        Label label = new Label("Image Drop Area");
        this.setTop(label);
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-border-color: lightgray");
        vbox.setPrefSize(105, 155);
        this.setCenter(vbox);

        // When a file is dragged over the scene, the background becomes
        // green and a copy message is displayed near the mouse
        this.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                    vbox.setStyle("-fx-border-color: lightgray; -fx-background-color: lightgreen");
                } else {
                    event.consume();
                }
            }
        });


        // Upon exiting, the background of the scene returns to White.
        this.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                vbox.setStyle("-fx-background-color: white; -fx-border-color: lightgray");
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
                    for (File file:db.getFiles()) {
                        Path filePath = file.toPath();
                        String fileName = file.toPath().toString();
                        if(fileName.toLowerCase().contains(".jpg")|| 
                                fileName.toLowerCase().contains(".jpeg") ||
                                fileName.toLowerCase().contains(".png")){
                            File targetFile = new File("./src/resources/guiResources/turtleImages/" 
                                + filePath.getFileName().toString());
                            try {
                                Files.copy(file.toPath(), targetFile.toPath(), REPLACE_EXISTING);
                            }
                            catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
                event.setDropCompleted(success);
                event.consume();

            }
        });
    }
}


