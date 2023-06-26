package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.controladores.ControladorVentana;
import edu.fiuba.algo3.Logger;


import edu.fiuba.algo3.Ventana;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;

import javafx.geometry.Pos;

import javafx.scene.Parent;

public class ViewFinal extends VBox implements Vista {

	public ViewFinal(Ventana ventana, boolean ganoJugador){
		//FXMLLoader.load()
        super();
        init(ventana,ganoJugador);
	}


	private void init(Ventana ventana, boolean ganoJugador){
		
		Parent view = Resources.getVista("menu_final");
		if(view == null){
			Logger.Log("ERROR LOADING MENU INICIO ... view was 'menu_inicio' null");
			return;
		}
		getChildren().add(view);

		Button buttonReiniciar  = (Button) view.lookup("#btnReiniciarJuego");
		Button buttonVolver  = (Button) view.lookup("#btnVolverInicio");
		Label labelGano  = (Label) view.lookup("#mensajeResultado");

		if(ganoJugador){
			labelGano.setText("Ganaste!!\nlos enemigos no podian matarte");
		} else{
			labelGano.setText("Perdiste!!\nlos enemigos te mataron");			
		}


		buttonReiniciar.setOnAction( (ActionEvent event)->{
			new ControladorVentana().reiniciarJuego(ventana);
		} );

		buttonVolver.setOnAction( (ActionEvent event)->{
			new ControladorVentana().terminarJuego(ventana);
		} );

		/*

		// anterior
        setAlignment(Pos.CENTER);
        Label label = new Label(titulo);
        TextField textFieldNombre = new TextField();
        Button button = new Button();

        button.setText(label_button);
        getChildren().add(label);
        getChildren().add(new Label("Antes de empezar, cual es tu nombre? (minimo 6 caracteres)"));
        getChildren().add(textFieldNombre);
        getChildren().add(button);

		 */

	}

	public Parent obtener(){
		return this;
		//return ">Menu principal AlgoDefense....\npodes iniciar juego con: >iniciar";
	}
	
}