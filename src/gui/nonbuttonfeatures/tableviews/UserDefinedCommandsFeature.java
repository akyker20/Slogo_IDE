package gui.nonbuttonfeatures.tableviews;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.variableslist.WorkspaceVariable;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class is a list view used to store previous commands. All commands that are entered
 * are put into this list (including commands that raise exceptions - thats how its done
 * in Matlab and other IDEs). The user can run a previous command by double clicking on
 * a list item.
 * @author Austin Kyker
 *
 */
public class UserDefinedCommandsFeature extends TableView<DisplayedUserCommand> {

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
    }
}
