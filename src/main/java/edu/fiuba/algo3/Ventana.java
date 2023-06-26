package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorVentana;
import edu.fiuba.algo3.modelo.Defensas.Defensa;

import edu.fiuba.algo3.vistas.ViewCelda;
import javafx.scene.Parent;
import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.Vista;

public class Ventana extends Scene{

	//private LayoutIntermediario layout;
	private ControladorVentana controlador;
	public void resetToInitial(){

		controlador.iniciarJuego(Resources.getJsonPath("mapa"),
				Resources.getJsonPath("enemigos"), this);		
	}

	public Ventana(int width, int height) throws Exception{

		// iniciar juego lo que hace es iniciar, y devuelva la pantalla inicial...
		super(ControladorVentana.menuInicio(), width,height);
		controlador = new ControladorVentana();

		//setRoot(new LayoutIntermediario());

		resetToInitial();

		//setRoot(new IntermediarioLayoutBasico());
	}

	/*
	public void setRoot(Parent vista){
		if(layout == null){
			Logger.Log("View Layout era null");
			super.setRoot(vista);
			return;
		}
		Logger.Log("View Layout ya existia entonces cambia solo");

		layout.setView(vista);
	}
	*/

	/*
	public void setRoot(LayoutIntermediario layout){
		Logger.Log("Cambiando layout...");
		this.layout = layout;
		super.setRoot(layout);
	}
	*/


	public void setVista(Vista vista){
		setRoot(vista.obtener());
	}

    public void iniciarConstruccionDefensa(Defensa defensa) {
    	Logger.Log("INICIANDO CONSTRUCCION ? "+defensa.toString());
		//layout.instanciarDefensa(defensa, this);
		//Parent view = ;
    }

	public boolean clickEnCelda(ViewCelda celda){
		return false;//layout.clickEnCelda(celda);
	}
}