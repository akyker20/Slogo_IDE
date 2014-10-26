package gui.nonbuttonfeatures.tableviews;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class is a list view used to store previous commands. All commands that are entered
 * are put into this list (including commands that raise exceptions - thats how its done
 * in Matlab and other IDEs). The user can run a previous command by double clicking on
 * a list item.
 * @author Austin Kyker
 *
 */
public class UserDefinedCommandsFeature extends TableView<DisplayedUserCommand> {

    private static final String POPUP_WIDTH = null;
    private static final String POPUP_HEIGHT = null;
    private ObservableList<DisplayedUserCommand> myCommandsList;

    public UserDefinedCommandsFeature(List<DisplayedUserCommand> userDefinedCommands){
        myCommandsList = (ObservableList<DisplayedUserCommand>) userDefinedCommands;


        TableColumn<DisplayedUserCommand,String> commandName = new TableColumn<DisplayedUserCommand,String>("Name");
        commandName.setCellValueFactory(new PropertyValueFactory("myName"));
        commandName.prefWidthProperty().bind(this.widthProperty().divide(3));
        TableColumn<DisplayedUserCommand,String> params = new TableColumn<DisplayedUserCommand,String>("Parameters");
        params.setCellValueFactory(new PropertyValueFactory("myParams"));
        params.prefWidthProperty().bind(this.widthProperty().multiply(2).divide(3).subtract(2));    
        this.getColumns().setAll(commandName, params);
        this.setItems(myCommandsList);
        this.setPrefHeight(168);
        this.setLayoutY(20);
        this.setOnMouseClicked(event->showCommandContent(event));
    }

    /**
     * When the user double clicks on a previous command that command will be displayed in the command
     * line so the user can quickly run it by hitting enter.
     * @param event
     */
    private void showCommandContent (MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            DisplayedUserCommand selectedCommand = this.getSelectionModel().getSelectedItem();
            if(event.getClickCount() == 2 && selectedCommand != null){
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
