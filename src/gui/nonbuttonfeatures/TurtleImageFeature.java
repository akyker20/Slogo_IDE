package gui.nonbuttonfeatures;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;
import gui.mainclasses.workspace.Workspace;
import gui.nonbuttonfeatures.tableviews.imageindex.ImageIndex;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Class is a BorderPane that allows the user to drag and drop images that will
 * be turned into ImageIndex objects and displayed in a tableview.
 * @author akyker20, allankiplagat
 *
 */
public class TurtleImageFeature extends BorderPane {

    private ObservableList<ImageIndex> myImageFilesList;
    private static final int VBOX_ROW_COUNT = 10;
    private static final int VBOX_WIDTH = 105;
    private static final int VBOX_HEIGHT = 155;
    private static TextGenerator textGen = TextGenerator.getInstance();

    public TurtleImageFeature (OptionsHolderDrawer parentDrawer,
                               List<ImageIndex> imageFilesList,
                               Workspace workspace) {
        myImageFilesList = (ObservableList<ImageIndex>) imageFilesList;
        Label label = new Label(textGen.get(TextGenerator.IMAGE_DROP_AREA));
        setTop(label);
        VBox vbox = new VBox(VBOX_ROW_COUNT);
        vbox.setStyle("-fx-border-color: lightgray");
        vbox.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
        setCenter(vbox);

        // When a file is dragged over the scene, the background becomes
        // green and a copy message is displayed near the mouse
        setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle (DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                    vbox.setStyle("-fx-border-color: lightgray; -fx-background-color: lightgreen");
                }
                else {
                    event.consume();
                }
            }
        });

        // Upon exiting, the background of the scene returns to green.
        setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle (DragEvent event) {
                vbox.setStyle("-fx-background-color: white; -fx-border-color: lightgray");
            }
        });

        // When a file is actually dropped it is validated to
        // ensure it has the correct name. The controller is
        // then called to initialize the driving environment.
        setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle (DragEvent event) {

                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    for (File file : db.getFiles()) {

                        Path filePath = file.toPath();
                        String fileName = file.toPath().toString();
                        if (fileName.toLowerCase().contains(".jpg") ||
                                fileName.toLowerCase().contains(".jpeg") ||
                                fileName.toLowerCase().contains(".png")) {
                            File targetFile = new File("./src/resources/guiResources/turtleImages/"
                                    + filePath.getFileName().toString());
                            try {
                                Files.copy(file.toPath(), targetFile.toPath(), REPLACE_EXISTING);
                                workspace.parseCommandString("setsp 0 " +
                                        targetFile.toPath().toString());
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
