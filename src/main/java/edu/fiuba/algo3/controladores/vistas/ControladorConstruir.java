package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Node;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorConstruir extends Controlador {


	public interface OnStartConstruccion {
		void empezarConstruccion(String construccion);
	}
	private OnStartConstruccion listener = (String cons)->{};
	public ControladorConstruir(OnStartConstruccion listener){
		if(listener != null){
			this.listener = listener;
		}
	}

	public void construirTorreBlanca(ActionEvent ev){
		listener.empezarConstruccion("TorreBlanca");
	}

	public void construirTorrePlateada(ActionEvent ev){
		listener.empezarConstruccion("TorrePlateada");
	}

	public void construirTrampa(ActionEvent ev){
		listener.empezarConstruccion("Trampa");
	}
}