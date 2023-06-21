package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.vistas.IntermediarioLayoutBasico;

import javafx.scene.Parent;
import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.Vista;

public class Ventana extends Scene{

	private IntermediarioLayoutBasico view;

	public Ventana(int width, int height) throws Exception{

		// iniciar juego lo que hace es iniciar, y devuelva la pantalla inicial...
		super(new IntermediarioLayoutBasico(), width,height);

		this.view = new IntermediarioLayoutBasico();
		setRoot(this.view);

		new ControladorJuego().iniciarJuego(Resources.getJsonPath("mapa"),
				Resources.getJsonPath("enemigos"), this);

		//setRoot(new IntermediarioLayoutBasico());
	}

	public void setVista(Vista vista){

		view.setView(vista.obtener());
		//setRoot(vista.obtener());
		// el setRoot en el caso de no ser fx, mostraria por consola?
	}

	public void addPopup(Parent popup){
		view.setPopup(popup);
	}

}