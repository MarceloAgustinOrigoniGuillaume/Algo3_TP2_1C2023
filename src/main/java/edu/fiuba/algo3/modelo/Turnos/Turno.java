package edu.fiuba.algo3.modelo.Turnos;

import java.util.ArrayList;
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

	public void jugarTurno(Mapa mapa,Jugador jugador, Oleada oleada){

		// move enemigos
		mapa.moverEnemigos();

		// defensas atacan mapa
		
		mapa.accionarDefensas();

		//for (Enemigo muerto : enemigosMuertos){
		//	jugador.ganoCreditos(muerto.creditosDados());
		//}
		// instancia enemigos.
		ArrayList<Enemigo> enemigos = oleada.instanciar(turno);
		
		for (Enemigo enemigo: enemigos){
			mapa.posicionarInicio(enemigo);
		}
		turno+=1;
	}
}