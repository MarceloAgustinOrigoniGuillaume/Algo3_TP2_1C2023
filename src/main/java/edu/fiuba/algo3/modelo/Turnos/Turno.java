package edu.fiuba.algo3.modelo.Turnos;

import java.util.ArrayList;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Oleada;
import edu.fiuba.algo3.modelo.Jugador;

public class Turno{

	private int turno;

	public Turno(){
		turno = 1;
	}

	public int turnoActual(){
		return turno;
	}

	public boolean jugarTurno(Mapa mapa,Jugador jugador, Oleada oleada){

		// move enemigos
		mapa.accionarEnemigos(jugador);

		if(jugador.estaMuerto()){
			Logger.info("Los enemigos mataron al jugador. Fin del juego");
			return false;
		}

		// defensas atacan mapa
		mapa.accionarDefensas();

		ArrayList<Enemigo> enemigos = oleada.instanciar(turno);
		
		for (Enemigo enemigo: enemigos){
			mapa.posicionarInicio(enemigo);
		}
		turno+=1;
		return true;
	}
}