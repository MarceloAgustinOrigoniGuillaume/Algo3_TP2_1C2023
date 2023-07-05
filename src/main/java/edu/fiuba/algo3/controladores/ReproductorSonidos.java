package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.modelo.descriptors.AttackDescriptor;
import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;
import java.util.ArrayList;

// por ahora aca el tema de reproducir
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
public class ReproductorSonidos implements OnAttackListener{
	public ReproductorSonidos() {
	}

	public void onAttack(AttackDescriptor ataque){
		// hay que ver como hacemos la logica.
		// pero creo un bueno singleton no vendria mal
		// sino habra que hacer unos cambios a como conectamos con el modelo
		//Logger.info("------------>SHOULD REPRODUCE SOUND '"+ataque.tipo()+"'");

		reproduceLater(ataque.tipo());
		//long time = System.currentTimeMillis();
		//Media sound = Resources.loadSound(ataque.tipo());
		//Media sound = Resources.load(ataque.tipo(), ()-> Resources.loadSound(ataque.tipo()));
		//MediaPlayer mediaPlayer = Resources.load(ataque.tipo(), ()-> Resources.loadPlayer(ataque.tipo()));
		//long time2 = System.currentTimeMillis();

		//MediaPlayer mediaPlayer = new MediaPlayer(sound);
		
		//long time3 = System.currentTimeMillis();
		//mediaPlayer.seek(Duration.ZERO);
		//Logger.info("-------------> load required ",time2-time,"ms");
		//Logger.info("-------------> create requited ",time3-time2,"ms");


		//mediaPlayer.play();
		// en vez de reproducir cosas ahora
		// capaz deberiamos esperar al final de turno.
	}

	public void reproduce(String sound){
		MediaPlayer mediaPlayer = Resources.load(sound, ()-> Resources.loadPlayer(sound));
		//Media mediaSound = Resources.load(sound, ()-> Resources.loadSound(sound));


		//MediaPlayer mediaPlayer = new MediaPlayer(mediaSound);
		mediaPlayer.seek(Duration.ZERO);
		mediaPlayer.play();

	}

	private MediaPlayer musicPlaying;
	public void setMusic(String music){
		String track = "music/"+music;
		//Logger.info("SETTING AMBIENT MUSIC TO",track);
		MediaPlayer mediaPlayer = Resources.loadPlayer(track);
		//Media mediaSound = Resources.load(sound, ()-> Resources.loadSound(sound));


		//MediaPlayer mediaPlayer = new MediaPlayer(mediaSound);
		//mediaPlayer.seek(Duration.ZERO);
		//mediaPlayer.setOnEndOfMedia(()->{
			//mediaPlayer.seek(Duration.ZERO);
		//});

		if(musicPlaying != null){
			musicPlaying.stop();
		}
		musicPlaying = mediaPlayer;

		mediaPlayer.play();
	}


	public ArrayList<String> toReproduce = new ArrayList<>();

	public void reproduceLater(String sound){
		if(toReproduce.contains(sound)){
			return;
		}

		toReproduce.add(sound);
	}

	public void reproduceAll(){
		ArrayList<String> reproducing = toReproduce;
		toReproduce = new ArrayList<>();
		for (String sound: reproducing){
			Logger.info("REP ALL ",sound);
			reproduce(sound);
		}
	}




}