package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.Logger;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

import javafx.scene.Parent;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;



public class ViewJuego extends StackPane implements Vista {

    //private Parent ultimo;

	public ViewJuego(ViewMapa mapaDelJuego){

        super();
        init(mapaDelJuego);
	}

	private void init(ViewMapa mapaDelJuego){
        getChildren().add(mapaDelJuego);
        mapaDelJuego.setAlignment(Pos.CENTER);
	}

	public Parent obtener(){
		return this;
        //return "";
	}
}