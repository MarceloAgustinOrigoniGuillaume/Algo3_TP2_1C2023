package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.DatosModelo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseDragEvent;

public class ControladorMenuInicio {
    @FXML
    private TextField playerName;

    @FXML
    private Button startGameButton;

    @FXML
    private Label nameWarning;
    String nombreJugador;

    public void submit(ActionEvent event) {
        nombreJugador = playerName.getText();
        if (nombreJugador.length() < 6) {
            nameWarning.setVisible(true);
        } else {
            nameWarning.setVisible(false);
            System.out.println("Ahora el jugador "+nombreJugador+" empieza a jugar");
            DatosModelo.empezarJuegoActual();
            DatosModelo.setNombreJugador(nombreJugador);
        }
    }
}
