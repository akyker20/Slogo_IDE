package gui.nonbuttonfeatures.tableviews.imageindex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class ImageIndexFeature extends TableView<ImageIndex> {
    @SuppressWarnings("unchecked")
    public ImageIndexFeature(ObservableList<ImageIndex> data, OptionsHolderDrawer parentDrawer){

        Callback<TableColumn<ImageIndex, File>, TableCell<ImageIndex, File>> cellFactory =
                new Callback<TableColumn<ImageIndex, File>, TableCell<ImageIndex, File>>() {
            public TableCell<ImageIndex, File> call(TableColumn<ImageIndex, File> p) {
                return new ImageFileCell();
            }
        };

        TableColumn<ImageIndex,Integer> index = new TableColumn<ImageIndex,Integer>("Index");
        index.setCellValueFactory(new PropertyValueFactory("myIndex"));
        index.prefWidthProperty().bind(this.widthProperty().divide(2));
        TableColumn<ImageIndex, File> imageCol = new TableColumn<ImageIndex, File>("Image");
        imageCol.setCellValueFactory(new PropertyValueFactory("myImageFile"));
        imageCol.prefWidthProperty().bind(this.widthProperty().divide(2).subtract(2));

        imageCol.setCellFactory(cellFactory);


        this.getColumns().setAll(index, imageCol);
        this.setItems(data);
        this.setPrefHeight(parentDrawer.getHeight());
    }

    private class ImageFileCell extends TableCell<ImageIndex, File> {
        @Override
        public void updateItem(File item, boolean empty) {
            super.updateItem(item, empty);
            if(!empty && item != null){
                ImageView imageView = new ImageView();
                try {
                    imageView.setImage(new Image(new FileInputStream(item), 80, 50, false, true));
                    this.setAlignment(Pos.CENTER);
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
