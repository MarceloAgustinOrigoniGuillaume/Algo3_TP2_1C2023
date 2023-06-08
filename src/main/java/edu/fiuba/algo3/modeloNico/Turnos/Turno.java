package edu.fiuba.algo3.Turnos;

import java.util.ArrayList;
import edu.fiuba.algo3.modeloNico.Enemigo;

public class Turno{

	private int turno;

	public Turno(){
		turno = 1;
	}

	public int turnoActual(){
		return turno;
	}

	public void jugarTurno(Mapa mapa, EstructurasActivas defensas, Oleadas oleadas){

		// move enemigos
		mapa.moverEnemigos();

		// defensas atacan mapa
		defensas.atacar(mapa);

		// instancia enemigos.
		ArrayList<Enemigo> enemigos = oleadas.instanciar(turno);
		
		for (Enemigo enemigo: enemigos){
			mapa.posicionarInicio(enemigo);
		}

		turno+=1;
	}


}