package edu.fiuba.algo3.Controladores;


import edu.fiuba.algo3.Controladores.Controlador;
import edu.fiuba.algo3.modelo.Juego;

import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.MenuInicio;
import edu.fiuba.algo3.vistas.ViewMapa;
import edu.fiuba.algo3.vistas.ViewCelda;
import edu.fiuba.algo3.vistas.ViewJuego;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;


public class ControladorJuego extends Controlador {
	public ControladorJuego() {
	}

	public MenuInicio iniciarJuego(String jsonMapa, String jsonEnemigos) throws Exception{
		DatosModelo.nuevoJuego(jsonMapa, jsonEnemigos);

		return new MenuInicio();
	}

	public boolean empezarJuego(Scene ventana, String nombreJugador){
		try{
			Logger.Log("Empezando juego con jugador '"+nombreJugador+"'");
			DatosModelo.empezarJuegoActual();
		} catch(Exception ex){
			Logger.Log("Error at empezar Juego "+ex.toString());
			ex.printStackTrace();
			return false;
		}

		ViewMapa mapa = new ViewMapa(DatosModelo.mapa_width,DatosModelo.mapa_height,(int x, int y)->{
			CeldaDescriptor datos= DatosModelo.obtenerTerrenoEn(x,y);

			return new ViewCelda(datos.tipo(), datos.cantidadEnemigos());
		});
		ViewJuego view = new ViewJuego(mapa);
		ventana.setRoot(view);

		return true;
	}

}