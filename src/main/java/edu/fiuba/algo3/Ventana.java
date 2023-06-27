package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorVentana;
import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.Vista;

public class Ventana extends Scene{

	private ControladorVentana controlador;

	public Ventana(int width, int height) throws Exception{

		// iniciar juego lo que hace es iniciar, y devuelva la pantalla inicial...
		super(ControladorVentana.menuInicio(), width,height);
		controlador = new ControladorVentana();

		controlador.iniciarJuego(Resources.getJsonPath("mapa"),
				Resources.getJsonPath("enemigos"), this);

		//setRoot(new IntermediarioLayoutBasico());
	}


	public void setVista(Vista vista){
		setRoot(vista.obtener());
	}
}