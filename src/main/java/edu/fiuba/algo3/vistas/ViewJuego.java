package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Ventana;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.geometry.Pos;

public class ViewJuego extends StackPane implements Vista {

    //private Parent ultimo;

	public ViewJuego(ViewMapa mapaDelJuego, Ventana ventana){

        super();
        init(mapaDelJuego, ventana);
	}

	private void init(ViewMapa mapaDelJuego, Ventana ventana){

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(mapaDelJuego);
		borderPane.setTop((new MenuConstrucciones(ventana)).obtener());

		getChildren().add(borderPane);
	}

	public Parent obtener(){
		return this;
        //return "";
	}
}