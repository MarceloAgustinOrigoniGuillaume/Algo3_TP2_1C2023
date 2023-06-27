package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorMenuInicio {
    @FXML
    public TextField playerName;

    @FXML
    public Button startGameButton;

    String name;

    public void submit(ActionEvent event) {
        name = playerName.getText();
        System.out.println(name);
    }
}
