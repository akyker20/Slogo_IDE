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

/**
 * Class manages the displaying of workspace variables in a tableview.
 * The user will be able to edit the variables as well.
 * @author akyker20, allankiplagat
 *
 */
public class WorkspaceVariablesFeature extends TableView<WorkspaceVariable> {
    
    public static final int TABLE_HEIGHT = 168;
    public static final int LAYOUT_Y = 20;
    public static final String TABLE_ID = "table";
    
    @SuppressWarnings("unchecked")
    public WorkspaceVariablesFeature (WorkspaceVariablesDrawer parentDrawer,
                                      ObservableList<WorkspaceVariable> data,
                                      Workspace workspace) {

        Callback<TableColumn<WorkspaceVariable, Double>, TableCell<WorkspaceVariable, Double>> cellFactory =
                new Callback<TableColumn<WorkspaceVariable, Double>, TableCell<WorkspaceVariable, Double>>() {
            @Override
            public TableCell<WorkspaceVariable, Double> call (TableColumn<WorkspaceVariable, Double> p) {
                return new EditingCell(workspace);
            }
        };

        TableColumn<WorkspaceVariable, String> variableName =
                new TableColumn<WorkspaceVariable, String>(
                        TextGenerator
                        .get(TextGenerator.VARIABLE));
        variableName.setCellValueFactory(new PropertyValueFactory("myName"));
        variableName.prefWidthProperty().bind(widthProperty().divide(2));
        TableColumn<WorkspaceVariable, Double> variableValue =
                new TableColumn<WorkspaceVariable, Double>(TextGenerator.get(TextGenerator.VALUE));
        variableValue.setCellValueFactory(new PropertyValueFactory("myValue"));
        variableValue.prefWidthProperty().bind(widthProperty().divide(2).subtract(2));
        variableValue.setCellFactory(cellFactory);
        getColumns().setAll(variableName, variableValue);
        setId(TABLE_ID);
        setLayoutY(LAYOUT_Y);
        setPrefHeight(TABLE_HEIGHT);
        setEditable(true);
        setItems(data);
        parentDrawer.drawShape(new WorkspaceVariablesFeature[] { this });
    }
}
