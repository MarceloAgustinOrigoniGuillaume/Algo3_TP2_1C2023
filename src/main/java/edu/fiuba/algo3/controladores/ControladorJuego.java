package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.modelo.Juego;

import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.MenuInicio;
import edu.fiuba.algo3.vistas.ViewMapa;
import edu.fiuba.algo3.vistas.ViewJuego;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Logger;


public class ControladorJuego extends Controlador{
	public ControladorJuego() {
	}

	public MenuInicio iniciarJuego(String jsonMapa, String jsonEnemigos) throws Exception{
		DatosModelo.nuevoJuego(jsonMapa, jsonEnemigos);

		return new MenuInicio();
	}

	public boolean empezarJuego(Scene ventana, String nombreJugador){
		try{
			DatosModelo.empezarJuegoActual();
		} catch(Exception ex){
			Logger.Log("Error at empezar Juego "+ex.toString());
			ex.printStackTrace();
			return false;
		}

		ViewMapa mapa = new ViewMapa(DatosModelo.mapa_width,DatosModelo.mapa_height,(int x, int y)->{
			return DatosModelo.obtenerTerrenoEn(x,y);
		});
		ViewJuego view = new ViewJuego(mapa);
		ventana.setRoot(view);

		return true;
	}

}