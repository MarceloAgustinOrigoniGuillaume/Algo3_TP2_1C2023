package edu.fiuba.algo3.controladores.vistasControladores;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;

import javafx.fxml.FXML;

import java.util.ResourceBundle;
//import javafx.beans.DefaultProperty;
//import edu.fiuba.algo3.vistas.Vista;


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