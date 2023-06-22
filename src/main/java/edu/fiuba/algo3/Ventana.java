package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.vistas.LayoutIntermediario;

import edu.fiuba.algo3.vistas.ViewCelda;
import javafx.scene.Parent;
import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.Vista;

public class Ventana extends Scene{

	private LayoutIntermediario view;

	public void resetToInitial(){

		this.view.resetConstruccion();
		new ControladorJuego().iniciarJuego(Resources.getJsonPath("mapa"),
				Resources.getJsonPath("enemigos"), this);		
	}

	public Ventana(int width, int height) throws Exception{

		// iniciar juego lo que hace es iniciar, y devuelva la pantalla inicial...
		super(new LayoutIntermediario(), width,height);

		this.view = new LayoutIntermediario();
		setRoot(this.view);

		resetToInitial();

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

    public void iniciarConstruccionDefensa(Defensa defensa) {

		view.instanciarDefensa(defensa, this);
		//Parent view = ;
    }

	public void clickEnCelda(ViewCelda celda){
		view.clickEnCelda(celda);
	}
	public void removePopUp() {
		view.removePopUp();
	}
}