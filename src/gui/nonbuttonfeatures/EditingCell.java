package gui.nonbuttonfeatures;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import Control.SlogoGraphics;
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
    private SlogoGraphics myControl;

    public EditingCell(SlogoGraphics control) {
        myControl = control;
        textField = new TextField();
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setGraphic(textField);
            textField.selectAll();
        }
    }


    public void createTextField() {
        textField = new TextField(getString());
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(Double.parseDouble(textField.getText()));
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            }
        });
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(""+getItem());
        setGraphic(null);
    }



    @Override
    public void updateItem(Double item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                WorkspaceVariable selectedVariable = this.getTableView().getSelectionModel().getSelectedItem();
                try {
                    myControl.parseCommandString("set " + selectedVariable.getMyName() + " " + selectedVariable.getMyValue());
                }
                catch (CompileTimeParsingException | RunTimeDivideByZeroException
                        | RunTimeNullPointerException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (textField != null) {
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(null);
            }
        }
    }

    protected String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}