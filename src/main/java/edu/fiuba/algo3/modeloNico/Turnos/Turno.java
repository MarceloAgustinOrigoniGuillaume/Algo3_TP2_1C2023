package edu.fiuba.algo3.modeloNico.Turnos;

import java.util.ArrayList;
import edu.fiuba.algo3.modeloNico.Enemigo.Enemigo;
import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modeloNico.Oleadas;
import edu.fiuba.algo3.modeloNico.Defensas.EstructurasActivas;

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