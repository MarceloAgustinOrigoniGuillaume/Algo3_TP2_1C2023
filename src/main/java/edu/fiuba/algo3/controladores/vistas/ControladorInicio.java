package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;

import edu.fiuba.algo3.AlgoDefense;


import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.vistas.popups.MessagePopup;


import edu.fiuba.algo3.modelo.descriptors.AttackDescriptor;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import edu.fiuba.algo3.vistas.ViewCelda;
import edu.fiuba.algo3.vistas.ViewMapa;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

// cambios a no usar Thread.
import edu.fiuba.algo3.controladores.LoadViewAsyncTask;

//import edu.fiuba.algo3.vistas.Vista;
//setBackground(Resources.getBckImage("background2.jpg", 640,680));


public class ControladorInicio extends Controlador {
	@FXML private TextField editNombreUsuario; 


	private String path_mapa;
	private String path_enemigos;

	public ControladorInicio(String path_mapa, String path_enemigos){
		this.path_mapa = path_mapa;
		this.path_enemigos = path_enemigos;
	}

	public ControladorInicio(){
		this(Resources.getJsonPath("mapa"),
			Resources.getJsonPath("enemigos"));
		// constructor default para un nivel default.
	}


	private boolean validarNombreJugador(String nombre){
		return nombre.length() >= 6;
	}


	private String obtenerNombre(){
		String nombreJugador = editNombreUsuario.getText();
		if(!validarNombreJugador(nombreJugador)){
			Logger.err("Nombre invalido '"+nombreJugador+"' el nombre tener al menos 6 caracteres");
			return null;
		}

		return nombreJugador;
	}

	public void iniciarJuego(ActionEvent event){

		String nombreJugador = obtenerNombre();
		if(nombreJugador == null){
			new MessagePopup("Error", "Nombre '"+editNombreUsuario.getText()+"' es invalido ").show(editNombreUsuario.getScene());

			return;
		}

		if(!empezarJuego(editNombreUsuario.getScene(), nombreJugador)){
			// show error popUp
			new MessagePopup("Error", "Error interno, no se puede iniciar el juego...").show(editNombreUsuario.getScene());
		}
	}

	public boolean empezarJuego(Scene ventana,String nombreJugador){

		// cargando... transicion.
		ventana.setRoot(Resources.getVista("transicion"));

		LoadViewAsyncTask loadTask= new LoadViewAsyncTask("juego",()->new ControladorJuego(
					path_mapa, path_enemigos,
					nombreJugador));

		loadTask.loadOn(ventana);

		return true;
	}
}