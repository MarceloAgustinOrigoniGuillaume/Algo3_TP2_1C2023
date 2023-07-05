package edu.fiuba.algo3.controladores.vistasControladores;


import edu.fiuba.algo3.controladores.ControladorVentana;
import edu.fiuba.algo3.modelo.AlgoDefense;


import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.controladores.ReproductorSonidos;


import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
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
	private ReproductorSonidos sonidos;

	private MediaPlayer playingVideo;
	public ControladorFinal(AlgoDefense mediatorJuego, ReproductorSonidos sonidos){
		this.mediatorJuego = mediatorJuego;
		this.sonidos = sonidos;
	}

	private void initializeOn(String url, String title){
		file1 = new File(url);
		media1 = new Media(file1.toURI().toString());
		playingVideo = new MediaPlayer(media1);

		mediaView.setMediaPlayer(playingVideo);
		playingVideo.play();
		mensajeResultado.setText(title.toUpperCase());

	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		if(mediatorJuego.ganoJugador()){
			initializeOn("src/main/resources/images/videos/youWin.mp4",
						"Ganaste!!");
		} else{
			initializeOn("src/main/resources/images/videos/youLoose.mp4",
						"Perdiste!!");
		}

	}

	public void volverInicio(ActionEvent event){
		try{
			sonidos.reproduce("start.mp3");
			playingVideo.stop();

			//String nombreJugador;
			mediatorJuego.terminarJuego();

			// volve a inicio
			mensajeResultado.getScene().setRoot(ControladorVentana.menuInicio(sonidos));

		} catch(Exception ex){
			Logger.err("at Final, volverInicio ",ex);
			ex.printStackTrace();
			return;
		}

	}

	public void reiniciarJuego(ActionEvent event){
		// cargando... transicion.
		sonidos.reproduce("start.mp3");
		playingVideo.stop();

		Scene scene = mensajeResultado.getScene();
		scene.setRoot(Resources.getVista("transicion"));

		LoadViewAsyncTask loadTask= new LoadViewAsyncTask(
			"juego",()->new ControladorJuego(mediatorJuego,sonidos));

		loadTask.loadOn(scene);
	}

}