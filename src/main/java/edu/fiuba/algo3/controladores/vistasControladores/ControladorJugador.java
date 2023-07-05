package edu.fiuba.algo3.controladores.vistasControladores;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.modelo.AlgoDefense;
import javafx.scene.control.Label;

import javafx.fxml.FXML;

//import edu.fiuba.algo3.vistas.Vista;
import edu.fiuba.algo3.controladores.ReproductorSonidos;


public class ControladorJugador extends Controlador {
	@FXML private Label labelNombre;
	@FXML private Label labelVida;
	@FXML private Label labelCreditos;


	private AlgoDefense mediatorJuego;
	private ReproductorSonidos sonidos;

	public ControladorJugador(AlgoDefense  mediatorJuego, ReproductorSonidos sonidos){
		this.mediatorJuego = mediatorJuego;
		this.sonidos = sonidos;
	}

	public void initialize(){
		labelNombre.setText(mediatorJuego.getNombreJugador());

		mediatorJuego.setObserverVida((String vida)->{
			labelVida.setText("Vida: "+vida);
			sonidos.reproduceLater("AtaqueAJugador.mp3");
		});

		mediatorJuego.setObserverCreditos((String creditos)->{
			labelCreditos.setText("Creditos: "+creditos);
		});
	}
	
}