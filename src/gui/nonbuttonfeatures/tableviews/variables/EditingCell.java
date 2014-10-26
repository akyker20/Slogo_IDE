package gui.nonbuttonfeatures.tableviews.variables;

import gui.mainclasses.workspace.Workspace;
import gui.variableslist.WorkspaceVariable;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *This class is a super class for different types of editing cells.
 *For now, there will only be a StringEditingCell because the integer
 *fields should not be editable, but this provides a means for future
 *extension.
 * @author Austin Kyker
 *
 */
public class EditingCell extends TableCell<WorkspaceVariable, Double> {

    private TextField textField;
    private Workspace myWorkspace;

    public EditingCell(Workspace workspace) {
        myWorkspace = workspace;
        textField = new TextField();
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
    }

    /**
     * When the user clicks on a cell, the editing process begins. A Textbox is
     * created that gives the user the ability to edit the value of the variable.
     */
    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setGraphic(textField);
            textField.selectAll();
        }
    }


    /**
     * A text box is created with a key listener. When the user hits enter
     * the contents of the text box are committed and the observable list is
     * edited! To let the back-end know of the variable change, a command is
     * sent to the control representing the change in the value of the variable.
     */
    public void createTextField() {
        textField = new TextField(getString());
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    Double newValue = Double.parseDouble(textField.getText());
                    commitEdit(newValue);

                    WorkspaceVariable selectedVariable = EditingCell.this.getTableView().getSelectionModel().getSelectedItem();
                    myWorkspace.parseCommandString("set " + selectedVariable.getMyName() + " " + newValue);


                }
            }
        });
    }

    /**
     * When the user edits a cell and presses enter in the text box, the item is updated
     * and the textbox is removed.
     */
    @Override
    public void updateItem(Double item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            setText(getString());
            setGraphic(null);
        }
    }

    /**
     * Method to return the item as a string. If the item is null (an empty cell),
     * an empty string is returned.
     * @return String representing item
     */
    protected String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}