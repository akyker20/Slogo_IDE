package gui.nonbuttonfeatures;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 * This class is a list view used to store previous commands. All commands that are entered
 * are put into this list (including commands that raise exceptions - thats how its done
 * in Matlab and other IDEs). The user can run a previous command by double clicking on
 * a list item.
 * @author Austin Kyker
 *
 */
public class UserDefinedCommandsFeature extends ListView<String> {

    private ObservableList<String> myCommandsList;

    public UserDefinedCommandsFeature(List<String> userDefinedCommands){
        myCommandsList = (ObservableList<String>) userDefinedCommands;
        this.setItems(myCommandsList);
        this.setPrefHeight(168);
        this.setLayoutY(20);
    }
}
