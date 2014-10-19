package gui.nonbuttonfeatures;

import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.variableslist.WorkspaceVariable;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WorkspaceVariablesFeature extends TableView<WorkspaceVariable> {
    public WorkspaceVariablesFeature(WorkspaceVariablesDrawer parentDrawer, ObservableList<WorkspaceVariable> data){
        this.setItems(data);
        TableColumn<WorkspaceVariable,String> firstNameCol = new TableColumn<WorkspaceVariable,String>("Variable");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("myName"));
        firstNameCol.prefWidthProperty().bind(this.widthProperty().divide(2));
        TableColumn<WorkspaceVariable,String> lastNameCol = new TableColumn<WorkspaceVariable,String>("Value");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("myValue"));
        lastNameCol.prefWidthProperty().bind(this.widthProperty().divide(2).subtract(2));
        this.getColumns().setAll(firstNameCol, lastNameCol);
        this.setId("table");
        this.setLayoutY(20);
        this.setPrefHeight(168);
        parentDrawer.drawShape(this);
    }
}
