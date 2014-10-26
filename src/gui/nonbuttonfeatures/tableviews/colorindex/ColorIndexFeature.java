package gui.nonbuttonfeatures.tableviews.colorindex;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;


/**
 * Class displays the indexed colors saved by the user for setting the turtle line color
 *
 * @author akyker20, allankiplagat
 *
 */
public class ColorIndexFeature extends TableView<ColorIndex> {
    @SuppressWarnings("unchecked")
    public ColorIndexFeature (ObservableList<ColorIndex> data, OptionsHolderDrawer parentDrawer) {

        Callback<TableColumn<ColorIndex, Color>, TableCell<ColorIndex, Color>> cellFactory =
                new Callback<TableColumn<ColorIndex, Color>, TableCell<ColorIndex, Color>>() {
            @Override
            public TableCell<ColorIndex, Color> call (TableColumn<ColorIndex, Color> p) {
                return new ColorCell();
            }
        };

        TableColumn<ColorIndex, Integer> index =
                new TableColumn<ColorIndex, Integer>(TextGenerator.get(TextGenerator.INDEX));
        index.setCellValueFactory(new PropertyValueFactory("myIndex"));
        index.prefWidthProperty().bind(widthProperty().divide(3));
        TableColumn<ColorIndex, Color> colorCol =
                new TableColumn<ColorIndex, Color>(TextGenerator.get(TextGenerator.COLOR));
        colorCol.setCellValueFactory(new PropertyValueFactory("myColor"));
        colorCol.prefWidthProperty().bind(widthProperty().multiply(2).divide(3).subtract(2));

        colorCol.setCellFactory(cellFactory);

        getColumns().setAll(index, colorCol);
        setItems(data);
        setPrefHeight(parentDrawer.getHeight());
    }

    private class ColorCell extends TableCell<ColorIndex, Color> {
        @Override
        public void updateItem (Color item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
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
