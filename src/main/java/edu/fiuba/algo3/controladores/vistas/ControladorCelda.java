package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorCelda extends Controlador {
	@FXML private Label textoEnemigos;
	@FXML private ImageView imagenTerreno;

	private CeldaDescriptor celda;
	public ControladorCelda(CeldaDescriptor celda){
		this.celda = celda;
	}

	public void initialize(){
		
	}

}