package edu.fiuba.algo3.modelo.Turnos;

import java.util.ArrayList;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Enemigo.Oleada;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Turno{

	private int turno;

	public Turno(){
		turno = 1;
	}

	public int turnoActual(){
		return turno;
	}

	public boolean jugarTurno(Mapa mapa,Jugador jugador, Oleada oleada){

		// move enemigos y que ataquen al jugador.
		Logger.info("----------------Accionando Turno: Accionar Enemigos");

		mapa.accionarEnemigos(jugador);

		if(jugador.estaMuerto()){
			Logger.info("Los enemigos mataron al jugador. Fin del juego");
			return false;
		}
		// defensas atacan mapa
		Logger.info("----------------Accionando Turno: Accionar Defensas");
		mapa.accionarDefensas();

		Logger.info("----------------Accionando Turno: Instanciando Enemigos");

		ArrayList<Enemigo> enemigos = oleada.instanciar(turno);
		
		for (Enemigo enemigo: enemigos){
			mapa.posicionarInicio(enemigo);
		}
		mapa.notificarInicioCambio();

		turno+=1;
		return true;
	}
}