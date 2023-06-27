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
}