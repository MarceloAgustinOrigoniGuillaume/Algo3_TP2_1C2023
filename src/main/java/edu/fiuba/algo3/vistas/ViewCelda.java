package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.Logger;


import javafx.scene.control.Button;
import javafx.scene.control.Label;


import javafx.scene.layout.StackPane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.image.ImageView;
import edu.fiuba.algo3.Resources;
import javafx.scene.input.MouseEvent;

public class ViewCelda extends StackPane {

    public static int TILE_SIZE = 41;
    
	public ViewCelda(String tipo, int cantidadEnemigos){
        super();
        init(tipo, cantidadEnemigos);
	}

    private void handleClick(MouseEvent event){
        Logger.Log("CLICKED ON TILE....");
        //Llama al click listener
        event.consume();
}

	private void init(String tipo, int cantidadEnemigos){

        ImageView img = new ImageView(Resources.getImg("terrenos/"+tipo+".jpg", TILE_SIZE, TILE_SIZE));

        img.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event)-> {
                Logger.Log("CLICKED ON TILE TIPO ERA "+tipo);
                event.consume();
            });//this::handleClick);

        getChildren().add(img);
	}	
}