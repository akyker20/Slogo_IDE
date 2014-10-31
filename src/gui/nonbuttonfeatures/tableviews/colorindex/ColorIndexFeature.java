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
 * in a tableview.
 *
 * @author akyker20, allankiplagat
 *
 */
public class ColorIndexFeature extends TableView<ColorIndex> {
    private static TextGenerator textGen = TextGenerator.getInstance();
    
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
                new TableColumn<ColorIndex, Integer>(textGen.get(TextGenerator.INDEX));
        index.setCellValueFactory(new PropertyValueFactory("myIndex"));
        index.prefWidthProperty().bind(widthProperty().divide(3));
        TableColumn<ColorIndex, Color> colorCol =
                new TableColumn<ColorIndex, Color>(textGen.get(TextGenerator.COLOR));
        colorCol.setCellValueFactory(new PropertyValueFactory("myColor"));
        colorCol.prefWidthProperty().bind(widthProperty().multiply(2).divide(3).subtract(2));

        colorCol.setCellFactory(cellFactory);

        getColumns().setAll(index, colorCol);
        setItems(data);
        setPrefHeight(parentDrawer.getHeight());
    }

    /**
     * Class is used to override the table cell class so that
     * we can draw a rectangle of the actual color instead of
     * simply a string representing the color.
     * @author Austin Kyker
     *
     */
    private class ColorCell extends TableCell<ColorIndex, Color> {
        
        private static final int COLOR_BAR_WIDTH = 150;
        private static final int COLOR_BAR_HEIGHT = 20;
        
        @Override
        public void updateItem (Color item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                Rectangle rect = new Rectangle(COLOR_BAR_WIDTH, COLOR_BAR_HEIGHT);
                rect.setStroke(Color.LIGHTGRAY);
                if (item != null) {
                    rect.setFill(item);
                    setGraphic(rect);
                }
            }
        }
    }
}
