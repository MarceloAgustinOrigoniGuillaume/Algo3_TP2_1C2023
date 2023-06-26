package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;
import edu.fiuba.algo3.DatosModelo;
import javafx.scene.control.Label;

import javafx.fxml.FXML;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorJugador extends Controlador {
	@FXML private Label labelNombre;
	@FXML private Label labelVida;
	@FXML private Label labelCreditos;

	private String nombreJugador;
	public ControladorJugador(String nombreJugador){
		this.nombreJugador = nombreJugador;
	}

	public void initialize(){
		labelNombre.setText(nombreJugador);

		DatosModelo.setObserverVida((String vida)->{
			labelVida.setText("Vida: "+vida);
		});

		DatosModelo.setObserverCreditos((String creditos)->{
			labelCreditos.setText("Creditos: "+creditos);
		});
	}
	
}