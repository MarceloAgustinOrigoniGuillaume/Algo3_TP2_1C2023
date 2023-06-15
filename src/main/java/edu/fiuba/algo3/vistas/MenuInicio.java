package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.Controladores.ControladorJuego;
import edu.fiuba.algo3.Logger;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.scene.Parent;


public class MenuInicio extends VBox implements Vista {
	private final static String titulo = "AlgoDefense";
	private final static String label_button = "Iniciar Juego";

	public MenuInicio(){

		//FXMLLoader.load()
        super();
        init();
	}


	private boolean validarNombreJugador(String nombre){
		return nombre.length() >= 6;
	}

	private void init(){
		setAlignment(Pos.CENTER);

		Parent view = Resources.getVista("menu_inicio");
		if(view == null){
			Logger.Log("ERROR LOADING MENU INICIO ... view was 'menu_inicio' null");
			return;
		}
		getChildren().add(view);

		TextField textFieldNombre = (TextField) view.lookup("#editNombreUsuario");
		Button button  = (Button) view.lookup("#btnIniciarJuego");

		button.setOnAction( (ActionEvent event)->{
			String nombreJugador = textFieldNombre.getText();
			if(!validarNombreJugador(nombreJugador)){
				Logger.Log("Nombre invalido '"+nombreJugador+"'");
				return;
			}

			new ControladorJuego().empezarJuego(getScene(),nombreJugador);
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