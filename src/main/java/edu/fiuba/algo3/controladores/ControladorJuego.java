package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;


public class ControladorJuego extends Controlador {
	public ControladorJuego() {
	}

	public void iniciarJuego(String jsonMapa, String jsonEnemigos, Ventana ventana){

		try{
			DatosModelo.nuevoJuego(jsonMapa, jsonEnemigos);
		} catch(Exception ex){
			Logger.Log("ERROR INICIANDO NUEVO JUEGO "+ex.toString());
			ex.printStackTrace();
		}

		ventana.setVista(new MenuInicio(ventana));
	}

	public boolean empezarJuego(Ventana ventana, String nombreJugador){
		
		try{
			Logger.Log("Empezando juego con jugador '"+nombreJugador+"'");
			DatosModelo.empezarJuegoActual();
			DatosModelo.pasarTurno();
			DatosModelo.pasarTurno();
			DatosModelo.pasarTurno();
			DatosModelo.pasarTurno();
		} catch(Exception ex){
			Logger.Log("Error at empezar Juego "+ex.toString());
			ex.printStackTrace();
			return false;
		}


		ViewJugador jugador = new ViewJugador(nombreJugador);




		ViewMapa mapa = new ViewMapa(DatosModelo.mapa_width,DatosModelo.mapa_height,(int x, int y)->{
			//Logger.Log("Obteniendo ........celda... ");
			return ControladorMapa.instanciarViewCelda(ventana::clickEnCelda ,
				 DatosModelo.obtenerTerrenoEn(x,y), x, y);
		});

		new ControladorMapa().setListenerCeldas(mapa);

		ViewJuego view = new ViewJuego(mapa,jugador, ventana);
		ventana.setVista(view);

		//new MenuConstrucciones();
		return true;
	}

	public void mostrarOpciones(Ventana ventana) {

		//new MenuConstrucciones(ventana);
		ventana.addPopup(new MenuConstruir(ventana));
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


	public void pasarTurno(Ventana ventana){

		// pasas turno

		if(!DatosModelo.pasarTurno()){
			Logger.Log("----------->HABIA TERMINADO EL JUEGO?");
			terminarJuego(ventana);
			return;
		}

		Logger.Log("Debio actualizar?");

	}


}