package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class ViewJugador extends VBox {
    private String nombre_jugador;
    private Label jugador_status;
    public ViewJugador(String nombre_jugador){
        super();
        this.nombre_jugador = nombre_jugador;

        init(nombre_jugador);
    }

    public void init(String nombre_jugador){

        getChildren().add(new Label(nombre_jugador));

        jugador_status = new Label("vida: 20 creditos: 100");
        getChildren().add(jugador_status);
    }

}
