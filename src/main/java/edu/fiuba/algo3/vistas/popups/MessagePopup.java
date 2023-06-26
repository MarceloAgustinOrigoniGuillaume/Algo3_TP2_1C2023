package edu.fiuba.algo3.vistas.popups;

import edu.fiuba.algo3.Logger;
import javafx.stage.Popup;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MessagePopup extends BasePopup {

    public MessagePopup(String title, String message){
        super();

        VBox layout = new VBox();

        layout.setStyle("-fx-background-color: #e9e9e9;-fx-padding: 10 10 10 10;");
        layout.getChildren().add(new Label(title));
        layout.getChildren().add(new Label(message));



        getContent().add(layout);
    }
}
