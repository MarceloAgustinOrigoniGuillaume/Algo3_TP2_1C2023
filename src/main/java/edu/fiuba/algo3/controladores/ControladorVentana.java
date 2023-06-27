package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.controladores.vistas.*;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;
import javafx.scene.Scene;
import javafx.scene.Parent;
import edu.fiuba.algo3.vistas.popups.BasePopup;


public class ControladorVentana extends Controlador {
	public ControladorVentana() {
	}

	public static Parent menuInicio(){
		return Resources.getVista("menu_inicio",new ControladorInicio());
	}

	public void iniciarJuego(String jsonMapa, String jsonEnemigos, Scene ventana){

		try{
			DatosModelo.nuevoJuego(jsonMapa, jsonEnemigos);
		} catch(Exception ex){
			Logger.Log("ERROR INICIANDO NUEVO JUEGO "+ex.toString());
			ex.printStackTrace();
		}

		//ventana.setRoot(Resources.getVista("menu_inicio",new ControladorInicio()));
		//ventana.setVista(new MenuInicio(ventana));
	}


	public void mostrarOpciones(Ventana ventana) {

		//new MenuConstrucciones(ventana);
        new BasePopup(new MenuConstruir(ventana)).show(ventana);
	}


	public void terminarJuego(Ventana ventana){

		// por ahora... vuelve a inicio de juego.

		DatosModelo.terminarJuego();
		try{
			ventana.resetToInitial();
		} catch(Exception ex){
			Logger.Log("ERROR INICIANDO NUEVO JUEGO "+ex.toString());
			ex.printStackTrace();
		}

	}



	public void reiniciarJuego(Ventana ventana){

		// por ahora... vuelve a inicio de juego.

		try{
			String nombreJugador;
			DatosModelo.reiniciarJuego();

			Logger.Log("EMPEZAR ? ? ? ");
			//empezarJuego(ventana,DatosModelo.getNombreJugador());

		} catch(Exception ex){
			Logger.Log("ERROR Re INICIANDO NUEVO JUEGO "+ex.toString());
			ex.printStackTrace();
			return;
		}

	}


	public void pasarTurno(Ventana ventana){

		// pasas turno

		if(!DatosModelo.pasarTurno()){
			Logger.Log("----------->HABIA TERMINADO EL JUEGO?");

			ventana.setVista(new ViewFinal(ventana, DatosModelo.ganoJugador()));	
			//terminarJuego(ventana);
			//return;
		}
	}


}