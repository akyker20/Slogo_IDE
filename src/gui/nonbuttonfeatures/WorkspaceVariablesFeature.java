package gui.nonbuttonfeatures;

import Control.SlogoGraphics;
import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.variableslist.WorkspaceVariable;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class WorkspaceVariablesFeature extends TableView<WorkspaceVariable> {
    @SuppressWarnings("unchecked")
    public WorkspaceVariablesFeature(WorkspaceVariablesDrawer parentDrawer, ObservableList<WorkspaceVariable> data, 
                                     SlogoGraphics control){
        this.setItems(data);

        Callback<TableColumn<WorkspaceVariable, Double>, TableCell<WorkspaceVariable, Double>> cellFactory =
                new Callback<TableColumn<WorkspaceVariable, Double>, TableCell<WorkspaceVariable, Double>>() {
            public TableCell<WorkspaceVariable, Double> call(TableColumn<WorkspaceVariable, Double> p) {
                return new EditingCell(control);
            }
        };

        TableColumn<WorkspaceVariable,String> variableName = new TableColumn<WorkspaceVariable,String>("Variable");
        variableName.setCellValueFactory(new PropertyValueFactory("myName"));
        variableName.prefWidthProperty().bind(this.widthProperty().divide(2));
        TableColumn<WorkspaceVariable,Double> variableValue = new TableColumn<WorkspaceVariable,Double>("Value");
        variableValue.setCellValueFactory(new PropertyValueFactory("myValue"));
        variableValue.prefWidthProperty().bind(this.widthProperty().divide(2).subtract(2));
        variableValue.setCellFactory(cellFactory);
        this.getColumns().setAll(variableName, variableValue);
        this.setId("table");
        this.setLayoutY(20);
        this.setPrefHeight(168);
        this.setEditable(true);
        parentDrawer.drawShape(new WorkspaceVariablesFeature[]{this});
    }
}
