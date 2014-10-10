package gui.nonbuttonfeatures;

import gui.componentdrawers.WorkspaceVariablesDrawer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WorkspaceVariablesFeature extends TableView<Variable> {
    public WorkspaceVariablesFeature(WorkspaceVariablesDrawer parentDrawer){
        final ObservableList<Variable> data = FXCollections.observableArrayList(
                                                                                new Variable("x", 1),
                                                                                new Variable("y",2)
                                                                               
                );
        this.setItems(data);

        TableColumn<Variable,String> firstNameCol = new TableColumn<Variable,String>("Variable");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("myName"));
        firstNameCol.prefWidthProperty().bind(this.widthProperty().divide(2));
        TableColumn<Variable,String> lastNameCol = new TableColumn<Variable,String>("Value");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("myValue"));
        lastNameCol.prefWidthProperty().bind(this.widthProperty().divide(2).subtract(2));
        this.getColumns().setAll(firstNameCol, lastNameCol);
        this.setId("table");
        this.setLayoutY(20);
        this.setPrefHeight(168);
        parentDrawer.drawShape(this);
    }
}
