package gui.nonbuttonfeatures.tableviews.imageindex;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * Presents the user with images that they can use as the turtle image
 * @author akyker20
 *
 */
public class ImageIndexFeature extends TableView<ImageIndex> {
    @SuppressWarnings("unchecked")
    public ImageIndexFeature (ObservableList<ImageIndex> data, OptionsHolderDrawer parentDrawer) {

        Callback<TableColumn<ImageIndex, File>, TableCell<ImageIndex, File>> cellFactory =
                new Callback<TableColumn<ImageIndex, File>, TableCell<ImageIndex, File>>() {
            @Override
            public TableCell<ImageIndex, File> call (TableColumn<ImageIndex, File> p) {
                return new ImageFileCell();
            }
        };

        TableColumn<ImageIndex, Integer> index =
                new TableColumn<ImageIndex, Integer>(TextGenerator.get(TextGenerator.INDEX));
        index.setCellValueFactory(new PropertyValueFactory("myIndex"));
        index.prefWidthProperty().bind(widthProperty().divide(2));
        TableColumn<ImageIndex, File> imageCol =
                new TableColumn<ImageIndex, File>(TextGenerator.get(TextGenerator.IMAGE));
        imageCol.setCellValueFactory(new PropertyValueFactory("myImageFile"));
        imageCol.prefWidthProperty().bind(widthProperty().divide(2).subtract(2));

        imageCol.setCellFactory(cellFactory);

        getColumns().setAll(index, imageCol);
        setItems(data);
        setPrefHeight(parentDrawer.getHeight());
    }

    private class ImageFileCell extends TableCell<ImageIndex, File> {
        @Override
        public void updateItem (File item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty && item != null) {
                ImageView imageView = new ImageView();
                try {
                    imageView.setImage(new Image(new FileInputStream(item), 80, 50, false, true));
                    setAlignment(Pos.CENTER);
                }
                catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                setGraphic(imageView);
            }
        }
    }
}
