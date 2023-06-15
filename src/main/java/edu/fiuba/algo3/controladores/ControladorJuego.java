package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vistas.*;


public class ControladorJuego extends Controlador{
	private Juego juego;
	public ControladorJuego(String jsonMapa, String jsonEnemigos) throws Exception{
		juego = new Juego(jsonMapa,jsonEnemigos);
	}


	public Vista menuInicial(){
		return new MenuInicio();
	}

	public Vista iniciarJuego(){
		juego.iniciarJuego();
		return new MenuInicio();
	}

}