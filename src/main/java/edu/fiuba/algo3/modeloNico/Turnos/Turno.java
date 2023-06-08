package edu.fiuba.algo3.modeloNico.Turnos;

import java.util.ArrayList;
import edu.fiuba.algo3.modeloNico.Enemigo.Enemigo;
import edu.fiuba.algo3.modeloNico.Celdas.Unidad;
import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modeloNico.Oleadas;
import edu.fiuba.algo3.modeloNico.Jugador;

public class Turno{

	private int turno;

	public Turno(){
		turno = 1;
	}

	public int turnoActual(){
		return turno;
	}

	public void jugarTurno(Mapa mapa,Jugador jugador, Oleadas oleadas){



		// move enemigos
		mapa.moverEnemigos();

		// defensas atacan mapa
		ArrayList<Unidad> enemigosMuertos = mapa.accionarDefensas();

		for (Unidad muerto : enemigosMuertos){
			jugador.ganoCreditos(muerto.creditosDados());
		}


		// instancia enemigos.
		ArrayList<Enemigo> enemigos = oleadas.instanciar(turno);
		
		for (Enemigo enemigo: enemigos){
			mapa.posicionarInicio(enemigo);
		}

		turno+=1;
	}


}