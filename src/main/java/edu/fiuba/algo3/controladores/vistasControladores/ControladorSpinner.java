package edu.fiuba.algo3.controladores.vistasControladores;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorSpinner implements Initializable {

    @FXML
    private Arc spinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(spinner);
        rotate.setDuration(Duration.millis(450));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);
        rotate.play();
    }
}
