package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Ventana;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.geometry.Pos;

public class ViewJuego extends StackPane implements Vista {

    //private Parent ultimo;
	private MenuAcciones menuAcciones;

	public ViewJuego(ViewMapa mapaDelJuego, ViewJugador jugador, Ventana ventana){

        super();
        init(mapaDelJuego,jugador, ventana);
	}

	private void init(ViewMapa mapaDelJuego, ViewJugador jugador , Ventana ventana){
		this.menuAcciones = new MenuAcciones(jugador, ventana);
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(mapaDelJuego);
		borderPane.setTop(menuAcciones.obtener());

		getChildren().add(borderPane);
	}

	public Parent obtener(){
		return this;
	}

	public void updateTurno(String turno){
		menuAcciones.setTurno(turno);

	}
}