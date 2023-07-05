package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorVentana;
import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.Vista;

public class Ventana extends Scene{

	public Ventana(int width, int height) throws Exception{

		// iniciar juego lo que hace es iniciar, y devuelva la pantalla inicial...
		super(ControladorVentana.menuInicio(), width,height);

		//setRoot(new IntermediarioLayoutBasico());
	}


	public void setVista(Vista vista){
		setRoot(vista.obtener());
	}
}