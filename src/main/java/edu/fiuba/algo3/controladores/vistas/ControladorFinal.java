package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.controladores.ControladorVentana;
import edu.fiuba.algo3.DatosModelo;


import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.vistas.popups.MessagePopup;



import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


//import edu.fiuba.algo3.vistas.Vista;
//setBackground(Resources.getBckImage("background2.jpg", 640,680));


public class ControladorFinal extends Controlador {
	@FXML private Label mensajeResultado; 

	private boolean ganoJugador;
	public ControladorFinal(boolean gano){
		this.ganoJugador = gano;
	}

	public void initialize(){

		if(ganoJugador){
			mensajeResultado.setText("Ganaste!!\nlos enemigos no podian matarte");
		} else{
			mensajeResultado.setText("Perdiste!!\nlos enemigos te mataron");			
		}

	}

	public void volverInicio(ActionEvent event){
		try{
			//String nombreJugador;
			DatosModelo.reiniciarJuego();
					
			// volve a inicio
			mensajeResultado.getScene().setRoot(ControladorVentana.menuInicio());

		} catch(Exception ex){
			Logger.err("at Final, volverInicio ",ex);
			ex.printStackTrace();
			return;
		}

	}

	public void reiniciarJuego(ActionEvent event){

		// reinicia
		try{
			Logger.info("Reiniciando juego...");
			DatosModelo.reiniciarJuego();
				
			ControladorInicio.empezarJuego(mensajeResultado.getScene(),DatosModelo.getNombreJugador());

		} catch(Exception ex){
			Logger.err("at reiniciando juego ",ex);
			ex.printStackTrace();
			return;
		}

	}




}