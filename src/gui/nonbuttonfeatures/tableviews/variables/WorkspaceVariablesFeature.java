package gui.nonbuttonfeatures.tableviews.variables;

import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.mainclasses.TextGenerator;
import gui.mainclasses.workspace.Workspace;
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
                                     Workspace workspace){

        Callback<TableColumn<WorkspaceVariable, Double>, TableCell<WorkspaceVariable, Double>> cellFactory =
                new Callback<TableColumn<WorkspaceVariable, Double>, TableCell<WorkspaceVariable, Double>>() {
            public TableCell<WorkspaceVariable, Double> call(TableColumn<WorkspaceVariable, Double> p) {
                return new EditingCell(workspace);
            }
        };

        TableColumn<WorkspaceVariable,String> variableName = 
                new TableColumn<WorkspaceVariable,String>(TextGenerator.get(TextGenerator.VARIABLE));
        variableName.setCellValueFactory(new PropertyValueFactory("myName"));
        variableName.prefWidthProperty().bind(this.widthProperty().divide(2));
        TableColumn<WorkspaceVariable,Double> variableValue = 
                new TableColumn<WorkspaceVariable,Double>(TextGenerator.get(TextGenerator.VALUE));
        variableValue.setCellValueFactory(new PropertyValueFactory("myValue"));
        variableValue.prefWidthProperty().bind(this.widthProperty().divide(2).subtract(2));
        variableValue.setCellFactory(cellFactory);
        this.getColumns().setAll(variableName, variableValue);
        this.setId("table");
        this.setLayoutY(20);
        this.setPrefHeight(168);
        this.setEditable(true);
        this.setItems(data);
        parentDrawer.drawShape(new WorkspaceVariablesFeature[]{this});
    }
}
