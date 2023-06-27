package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.DatosModelo;


import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.vistas.popups.MessagePopup;



import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.vistas.ViewCelda;
import edu.fiuba.algo3.vistas.ViewMapa;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import java.lang.Thread;


//import edu.fiuba.algo3.vistas.Vista;
//setBackground(Resources.getBckImage("background2.jpg", 640,680));


public class ControladorInicio extends Controlador {
	@FXML private TextField editNombreUsuario; 

	public ControladorInicio(){
		Logger.Log("Construyendo controlador Inicio sin params");
	}


	public ControladorInicio(Ventana ventana){
		Logger.Log("Construyendo controlador Inicio con ventana..."+ventana.toString());
	}


	private boolean validarNombreJugador(String nombre){
		return nombre.length() >= 6;
	}


	private String obtenerNombre(){
		String nombreJugador = editNombreUsuario.getText();
		if(!validarNombreJugador(nombreJugador)){
			Logger.Log("Nombre invalido '"+nombreJugador+"' el nombre tener al menos 6 caracteres");
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

	public static boolean empezarJuego(Scene ventana, String nombreJugador){

		try{
			Logger.Log("Empezando juego con jugador '"+nombreJugador+"'");
			DatosModelo.empezarJuegoActual();
			DatosModelo.setNombreJugador(nombreJugador);
		} catch(Exception ex){
			Logger.Log("Error at empezar Juego "+ex);
			ex.printStackTrace();
			return false;
		}


		// cargando... transicion.
		ventana.setRoot(Resources.getVista("transicion"));

		Thread juegoLoader = new Thread(()->{
			VBox juego = Resources.getVista("juego",new ControladorJuego(nombreJugador));

			// no es ideal usar el setRoot en otro thread..
			// o eso dicen en otros frameworks.
			ventana.setRoot(juego);
		});

		juegoLoader.setDaemon(true);

		juegoLoader.start();

		return true;
	}



}