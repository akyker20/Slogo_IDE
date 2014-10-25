package gui.nonbuttonfeatures.tableviews;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class ColorIndexFeature extends TableView<ColorIndex> {
    @SuppressWarnings("unchecked")
    public ColorIndexFeature(ObservableList<ColorIndex> data, OptionsHolderDrawer parentDrawer){

        TableColumn<ColorIndex,Integer> variableName = new TableColumn<ColorIndex,Integer>("Index");
        variableName.setCellValueFactory(new PropertyValueFactory("myIndex"));
        variableName.prefWidthProperty().bind(this.widthProperty().divide(3));
        TableColumn<ColorIndex,Color> variableValue = new TableColumn<ColorIndex,Color>("Color");
        variableValue.setCellValueFactory(new PropertyValueFactory("myColor"));
        variableValue.prefWidthProperty().bind(this.widthProperty().multiply(2).divide(3).subtract(2));
        this.getColumns().setAll(variableName, variableValue);
        this.setItems(data);
        this.setPrefHeight(parentDrawer.getHeight());
    }
}
