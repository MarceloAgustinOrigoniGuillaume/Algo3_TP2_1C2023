package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;

import edu.fiuba.algo3.modelo.descriptors.AttackDescriptor;
import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;


// por ahora aca el tema de reproducir
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproductorSonidos implements OnAttackListener{
	public ReproductorSonidos() {
	}

	public void onAttack(AttackDescriptor ataque){
		// hay que ver como hacemos la logica.
		// pero creo un bueno singleton no vendria mal
		// sino habra que hacer unos cambios a como conectamos con el modelo
		Logger.info("------------>SHOULD REPRODUCE SOUND '"+ataque.tipo()+"'");

		Media sound = new Media(Resources.getSoundPath(ataque.tipo()));
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		// en vez de reproducir cosas ahora
		// capaz deberiamos esperar al final de turno.
	}

}