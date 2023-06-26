package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.vistas.ViewFinal;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.DatosModelo;
import javafx.scene.Scene;
import edu.fiuba.algo3.Resources;

//import edu.fiuba.algo3.vistas.Vista;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;


public class ControladorJuego extends Controlador {
	private boolean construyendo;
	@FXML private HBox statusBar;

	private String nombreJugador;
	public ControladorJuego(String nombreJugador){
		this.nombreJugador = nombreJugador;
	}

	public void initialize(){

		statusBar.getChildren().add(Resources.getVista("jugador",new ControladorJugador(nombreJugador)));
		statusBar.getChildren().add(Resources.getVista("menu_acciones",new ControladorMenuAcciones(this)));
		
	}

	public void testButton(ActionEvent ev){
		Logger.Log("EVENTO CLICK TEST");
	}


	public void toggleConstruyendo(){
		construyendo = !construyendo;
	}

	public boolean estaConstruyendo(){
		return construyendo;
	}


	public void pasarTurno(Scene scene){

		// pasas turno

		if(!DatosModelo.pasarTurno()){
			Logger.Log("----------->HABIA TERMINADO EL JUEGO?");
			

			scene.setRoot(Resources.getVista("menu_final",new ControladorFinal(DatosModelo.ganoJugador())));
			//terminarJuego(ventana);
			//return;
		}
	}

}