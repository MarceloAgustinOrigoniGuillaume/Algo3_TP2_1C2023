package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.Logger;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Parent;


public class MenuConstrucciones extends HBox {

	public MenuConstrucciones(){
        super();
        init();
	}

	private void init(){
        Parent view = Resources.getVista("menu_construcciones");
        getChildren().add(view);
        
	}	
}