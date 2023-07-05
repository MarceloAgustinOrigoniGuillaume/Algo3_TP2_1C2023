package edu.fiuba.algo3.vistas.popups;

import edu.fiuba.algo3.Logger;
import javafx.stage.Popup;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MessagePopup extends BasePopup {

	//private VBox alert;
    public MessagePopup(String title, String message){
        super();

        VBox layout = new VBox();
        HBox title_layout = new HBox();

        Button btnCerrar = new Button();

        btnCerrar.setText("x");
        btnCerrar.setOnAction((ActionEvent event)->{
        	this.hide();
        });
        title_layout.getChildren().add(btnCerrar);
        title_layout.getChildren().add(new Label(title));


        layout.setStyle("-fx-background-color: #e9e9e9;-fx-padding: 10 10 10 10;"+
        	"-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);");
        layout.getChildren().add(title_layout);
        layout.getChildren().add(new Label(message));

        getContent().add(layout);
        setHideOnEscape(true);
        setAutoHide(false);
        setConsumeAutoHidingEvents(true);        
    }

    /*
    public void show(Window window){        
        alert.setPrefWidth(window.getWidth());
        alert.setPrefHeight(window.getHeight());
        super.show(window);

        alert.requestFocus();
    }
	*/
}
