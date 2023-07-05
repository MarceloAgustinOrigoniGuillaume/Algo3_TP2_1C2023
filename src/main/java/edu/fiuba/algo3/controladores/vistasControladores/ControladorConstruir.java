package edu.fiuba.algo3.controladores.vistasControladores;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorConstruir extends Controlador {


	@FXML private Label costoTorreBlanca;
	@FXML private Label costoTorrePlateada;
	@FXML private Label costoTrampa;
	@FXML private Label rangoTorreBlanca;
	@FXML private Label rangoTorrePlateada;
	@FXML private Label danioTorreBlanca;
	@FXML private Label danioTorrePlateada;
	@FXML private Label tiempoTorreBlanca;
	@FXML private Label tiempoTorrePlateada;

	private TorreBlanca torreBlanca = new TorreBlanca();
	private TorrePlateada torrePlateada = new TorrePlateada();
	private Trampa trampa = new Trampa();

	public interface OnStartConstruccion {
		void empezarConstruccion(String construccion);
	}
	public void initialize(){
		//Logger.Log("INITIALIZED MENU ACCIONES, status bar");

		costoTorreBlanca.setText(String.valueOf(torreBlanca.costo()));
		costoTorrePlateada.setText(String.valueOf(torrePlateada.costo()));
		costoTrampa.setText(String.valueOf(trampa.costo()));
		rangoTorreBlanca.setText(String.valueOf(torreBlanca.obtenerRango()));
		rangoTorrePlateada.setText(String.valueOf(torrePlateada.obtenerRango()));
		danioTorreBlanca.setText(String.valueOf(torreBlanca.ataque()));
		danioTorrePlateada.setText(String.valueOf(torrePlateada.ataque()));
		tiempoTorreBlanca.setText(String.valueOf(torreBlanca.getTiempoConstruccion()));
		tiempoTorrePlateada.setText(String.valueOf(torrePlateada.getTiempoConstruccion()));

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