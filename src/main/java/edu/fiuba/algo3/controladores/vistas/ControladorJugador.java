package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;
import edu.fiuba.algo3.AlgoDefense;
import javafx.scene.control.Label;

import javafx.fxml.FXML;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorJugador extends Controlador {
	@FXML private Label labelNombre;
	@FXML private Label labelVida;
	@FXML private Label labelCreditos;


	private AlgoDefense mediatorJuego;

	public ControladorJugador(AlgoDefense  mediatorJuego){
		this.mediatorJuego = mediatorJuego;
	}

	public void initialize(){
		labelNombre.setText(mediatorJuego.getNombreJugador());

		mediatorJuego.setObserverVida((String vida)->{
			labelVida.setText("Vida: "+vida);
		});

		mediatorJuego.setObserverCreditos((String creditos)->{
			labelCreditos.setText("Creditos: "+creditos);
		});
	}
	
}