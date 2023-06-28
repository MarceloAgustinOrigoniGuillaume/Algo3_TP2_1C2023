package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.controladores.ControladorVentana;
import edu.fiuba.algo3.AlgoDefense;


import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.vistas.popups.MessagePopup;



import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import edu.fiuba.algo3.controladores.LoadViewAsyncTask;

//import edu.fiuba.algo3.vistas.Vista;
//setBackground(Resources.getBckImage("background2.jpg", 640,680));


public class ControladorFinal implements Initializable {
	@FXML private Label mensajeResultado;

	@FXML
	private MediaView mediaView;

	private File file1;
	private File file2;
	private Media media1;
	private MediaPlayer mediaPlayer1;
	private Media media2;
	private MediaPlayer mediaPlayer2;
	
	private AlgoDefense mediatorJuego;


	public ControladorFinal(AlgoDefense mediatorJuego){
		this.mediatorJuego = mediatorJuego;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		file1 = new File("src/main/resources/images/videos/youWin.mp4");
		media1 = new Media(file1.toURI().toString());
		mediaPlayer1 = new MediaPlayer(media1);

		file2 = new File("src/main/resources/images/videos/youLoose.mp4");
		media2 = new Media(file2.toURI().toString());
		mediaPlayer2 = new MediaPlayer(media2);


		String mensajeFinal;
		if(mediatorJuego.ganoJugador()){
			mediaView.setMediaPlayer(mediaPlayer1);
			mediaPlayer1.play();
			mensajeResultado.setText("Ganaste!!");
			mensajeFinal = mensajeResultado.getText();
			mensajeResultado.setText(mensajeFinal.toUpperCase());
		} else{
			mediaView.setMediaPlayer(mediaPlayer2);
			mediaPlayer2.play();
			mensajeResultado.setText("Perdiste!!");
			mensajeFinal = mensajeResultado.getText();
			mensajeResultado.setText(mensajeFinal.toUpperCase());
		}

	}

	public void volverInicio(ActionEvent event){
		try{
			//String nombreJugador;
			mediatorJuego.terminarJuego();

			// volve a inicio
			mensajeResultado.getScene().setRoot(ControladorVentana.menuInicio());

		} catch(Exception ex){
			Logger.err("at Final, volverInicio ",ex);
			ex.printStackTrace();
			return;
		}

	}

	public void reiniciarJuego(ActionEvent event){
		// cargando... transicion.

		mensajeResultado.getScene().setRoot(Resources.getVista("transicion"));

		LoadViewAsyncTask loadTask= new LoadViewAsyncTask(
			"juego",()->new ControladorJuego(mediatorJuego));

		loadTask.loadOn(mensajeResultado.getScene());
	}

}