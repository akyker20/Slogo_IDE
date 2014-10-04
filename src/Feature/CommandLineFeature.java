package Feature;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import GUI.CommandLineDrawer;

public class CommandLineFeature extends TextField implements Feature {

    public CommandLineFeature(CommandLineDrawer parentDrawer){
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode().equals(KeyCode.ENTER)) {
                    System.out.println(CommandLineFeature.this.getText());
                    CommandLineFeature.this.clear();
                }
            }
        });

        parentDrawer.drawShape(this);
    }

    @Override
    public void act () {
        // TODO Auto-generated method stub

    }

}
