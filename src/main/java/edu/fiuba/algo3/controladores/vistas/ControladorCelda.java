package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.vistas.celda.CeldaView;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import java.util.ResourceBundle;
//import javafx.beans.DefaultProperty;
//import edu.fiuba.algo3.vistas.Vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

public class ControladorCelda extends Controlador {
	//@FXML private Label textoEnemigos;
	//@FXML private ImageView imagenTerreno;
	
	@FXML private ResourceBundle resources;


	private String source;
//${controller.defensaImg}
	public ControladorCelda(){
		source = "URL 1";
	}

	public String getSource() {
		return source;
	}

	public void setSource(String src) {
		source = src;
	}

	public void initialize(){
		//myCoordenadas.addAll(new Coordenada(0,8),new Coordenada(1,3));
		
		if(resources == null){
			Logger.info("RESOURCES WAS NULL");
			return;
		}

		Logger.info("CELDA INITED ",resources);
		//resources.getString("posX");
	}

}