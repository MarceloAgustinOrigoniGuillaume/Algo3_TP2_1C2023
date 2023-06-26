package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.controladores.ControladorMapa;
import edu.fiuba.algo3.DatosModelo;


import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.vistas.popups.MessagePopup;



import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.vistas.ViewCelda;
import edu.fiuba.algo3.vistas.ViewJugador;
import edu.fiuba.algo3.vistas.ViewMapa;
import edu.fiuba.algo3.vistas.ViewJuego;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;


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
			Logger.Log("Nombre invalido '"+nombreJugador+"'");
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
			Logger.Log("Error at empezar Juego "+ex.toString());
			ex.printStackTrace();
			return false;
		}

		ControladorJuego controlador = new ControladorJuego(nombreJugador);
		VBox juego = Resources.getVista("juego",controlador);		

		/*
		ViewMapa mapa = new ViewMapa(DatosModelo.mapa_width,DatosModelo.mapa_height,(int x, int y)->{
			//Loggerz.Log("Obteniendo ........celda... ");
			return ControladorMapa.instanciarViewCelda((ViewCelda celda)->{
				Logger.Log("CLICKED ON "+celda.toString()+" from controlador");
				return true;
			} ,
				 DatosModelo.obtenerTerrenoEn(x,y), x, y);
		});

		//juego.getChildren().add(Resources.getVista("menu_acciones",new ControladorMenuAcciones(controlador)));
		*/
		ventana.setRoot(juego);


		return true;

		/*


		ViewJugador jugador = new ViewJugador(nombreJugador);

		DatosModelo.setObserverVida(jugador::update_vida);
		DatosModelo.setObserverCreditos(jugador::update_creditos);


		new ControladorMapa().setListenerCeldas(mapa);

		ViewJuego view = new ViewJuego(mapa,jugador, (Ventana) ventana);
		
		//ventana.setRoot(Resources.getVista("menu_inicio",new ControladorInicio()));

		ventana.setRoot(view);

		DatosModelo.setObserverTurno(view::updateTurno);

		//new MenuConstrucciones();
		return true;
		*/
	}



}