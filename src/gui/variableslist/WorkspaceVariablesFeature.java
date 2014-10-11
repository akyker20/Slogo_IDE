package gui.variableslist;

import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.mainclasses.GUIController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WorkspaceVariablesFeature extends TableView<WorkspaceVariable> {
    private static ObservableList<WorkspaceVariable> data;
    
    public WorkspaceVariablesFeature(WorkspaceVariablesDrawer parentDrawer){
        //Map<String, double> 
        data = FXCollections.observableArrayList(GUIController.GUI_WORKSPACE_VARIABLE_MAP.values());
        this.setItems(data);
        this.setEditable(true);

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
    
    public static void resetObservableList() {
        data = FXCollections.observableArrayList(GUIController.GUI_WORKSPACE_VARIABLE_MAP.values());
    }
}
