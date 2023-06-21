package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;


public class ControladorJuego extends Controlador {
	public ControladorJuego() {
	}

	public void iniciarJuego(String jsonMapa, String jsonEnemigos, Ventana ventana) throws Exception{
		DatosModelo.nuevoJuego(jsonMapa, jsonEnemigos);

		ventana.setVista(new MenuInicio(ventana));
	}

	public boolean empezarJuego(Ventana ventana, String nombreJugador){
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
		ViewJuego view = new ViewJuego(mapa, ventana);
		ventana.setVista(view);

		//new MenuConstrucciones();
		return true;
	}

	public void mostrarOpciones(Ventana ventana) {

		//new MenuConstrucciones(ventana);
		ventana.addPopup(new MenuConstruir(ventana));

	}
}