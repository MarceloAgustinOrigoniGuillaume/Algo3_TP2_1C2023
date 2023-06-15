package edu.fiuba.algo3;

import javafx.scene.Scene;
import edu.fiuba.algo3.Controladores.*;
import edu.fiuba.algo3.vistas.Vista;
import edu.fiuba.algo3.vistas.MenuInicio;

public class Ventana extends Scene{


	public Ventana(int width, int height) throws Exception{

		// iniciar juego lo que hace es iniciar, y devuelva la pantalla inicial...
		super(new ControladorJuego().iniciarJuego(
			"src/main/resources/archivos-json/mapa.json","src/main/resources/archivos-json/enemigos.json")
			, width,height);
	}


	public void setVista(Vista vista){
		setRoot(vista.obtener());
		// el setRoot en el caso de no ser fx, mostraria por consola?
	}

	public void show(){

	}

}