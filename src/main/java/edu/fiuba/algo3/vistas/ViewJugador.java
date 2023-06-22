package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class ViewJugador extends VBox {
    private String nombre_jugador;
    private Label jugador_status_creditos;

    private Label jugador_status_vida;

    public ViewJugador(String nombre_jugador){
        super();
        this.nombre_jugador = nombre_jugador;

        init(nombre_jugador);
    }

    public void init(String nombre_jugador){

        getChildren().add(new Label(nombre_jugador));

        jugador_status_vida = new Label("vida: 20 ");

        jugador_status_creditos = new Label("Creditos: 100");

        getChildren().add(jugador_status_vida);
        getChildren().add(jugador_status_creditos);
    }

    public void update_creditos(String nuevos_creditos){
        jugador_status_creditos.setText("Creditos: "+nuevos_creditos);
    }

    public void update_vida(String nueva_vida) {
        jugador_status_vida.setText("Vida: "+nueva_vida);
    }
}
