package Feature;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import GUI.CommandLineDrawer;

public class CommandLineFeature implements Feature {

    public CommandLineFeature(CommandLineDrawer parentDrawer){
        TextField textField = new TextField();
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode().equals(KeyCode.ENTER)) {
                    System.out.println(textField.getText());
                    textField.clear();
                }
            }
        });

        parentDrawer.drawShape(textField);
    }

    @Override
    public void act () {
        // TODO Auto-generated method stub

    }

}
