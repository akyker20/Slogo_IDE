package gui.nonbuttonfeatures.tableviews;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class ColorIndexFeature extends TableView<ColorIndex> {
    @SuppressWarnings("unchecked")
    public ColorIndexFeature(ObservableList<ColorIndex> data, OptionsHolderDrawer parentDrawer){

        Callback<TableColumn<ColorIndex, Color>, TableCell<ColorIndex, Color>> cellFactory =
                new Callback<TableColumn<ColorIndex, Color>, TableCell<ColorIndex, Color>>() {
            public TableCell<ColorIndex, Color> call(TableColumn<ColorIndex, Color> p) {
                return new ColorCell();
            }
        };

        TableColumn<ColorIndex,Integer> index = new TableColumn<ColorIndex,Integer>("Index");
        index.setCellValueFactory(new PropertyValueFactory("myIndex"));
        index.prefWidthProperty().bind(this.widthProperty().divide(3));
        TableColumn<ColorIndex,Color> colorCol = new TableColumn<ColorIndex,Color>("Color");
        colorCol.setCellValueFactory(new PropertyValueFactory("myColor"));
        colorCol.prefWidthProperty().bind(this.widthProperty().multiply(2).divide(3).subtract(2));

        colorCol.setCellFactory(cellFactory);


        this.getColumns().setAll(index, colorCol);
        this.setItems(data);
        this.setPrefHeight(parentDrawer.getHeight());
    }

    static class ColorCell extends TableCell<ColorIndex, Color> {
        @Override
        public void updateItem(Color item, boolean empty) {
            super.updateItem(item, empty);
            if(!empty){
                Rectangle rect = new Rectangle(150, 20);
                rect.setStroke(Color.LIGHTGRAY);
                if (item != null) {
                    rect.setFill(item);
                    setGraphic(rect);
                }
            }
        }
    }
}
