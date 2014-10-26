package gui.nonbuttonfeatures.tableviews;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.mainclasses.TextGenerator;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * This class is a tableview used to store user defined commands.
 * The table will display the name of the function as well as the 
 * parameters. If the user double clicks on the function, they will be
 * able to see the content as well.
 *
 * @author Austin Kyker
 *
 */
public class UserDefinedCommandsFeature extends TableView<DisplayedUserCommand> {

    private static final String POPUP_WIDTH = null;
    private static final String POPUP_HEIGHT = null;
    private ObservableList<DisplayedUserCommand> myCommandsList;

    public UserDefinedCommandsFeature (List<DisplayedUserCommand> userDefinedCommands) {
        myCommandsList = (ObservableList<DisplayedUserCommand>) userDefinedCommands;

        TableColumn<DisplayedUserCommand, String> commandName =
                new TableColumn<DisplayedUserCommand, String>(TextGenerator.get(TextGenerator.NAME));
        commandName.setCellValueFactory(new PropertyValueFactory("myName"));
        commandName.prefWidthProperty().bind(widthProperty().divide(3));
        TableColumn<DisplayedUserCommand, String> params =
                new TableColumn<DisplayedUserCommand, String>(
                        TextGenerator
                        .get(TextGenerator.PARAMETERS));
        params.setCellValueFactory(new PropertyValueFactory("myParams"));
        params.prefWidthProperty().bind(widthProperty().multiply(2).divide(3).subtract(2));
        getColumns().setAll(commandName, params);
        setItems(myCommandsList);
        setPrefHeight(168);
        setLayoutY(20);
        setOnMouseClicked(event -> showCommandContent(event));
    }

    /**
     * When the user double clicks on a previous command that command will be displayed in the
     * command
     * line so the user can quickly run it by hitting enter.
     *
     * @param event
     */
    private void showCommandContent (MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            DisplayedUserCommand selectedCommand = getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 2 && selectedCommand != null) {
                Stage popup = new Stage();
                popup.setX(event.getScreenX());
                popup.setY(event.getScreenY());
                BorderPane pane = new BorderPane();
                Scene scene = new Scene(pane);
                Label label = new Label(selectedCommand.getMyName());
                label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold");
                pane.setTop(label);
                VBox vbox = new VBox();
                vbox.setPadding(new Insets(10));
                Label contentLabel = new Label(selectedCommand.getMyContent());
                vbox.getChildren().add(contentLabel);
                vbox.setAlignment(Pos.CENTER);
                pane.setCenter(vbox);
                popup.setScene(scene);
                popup.show();
            }
        }
    }

}
