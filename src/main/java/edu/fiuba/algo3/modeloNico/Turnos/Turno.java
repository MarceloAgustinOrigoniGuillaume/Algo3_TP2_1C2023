package edu.fiuba.algo3.modeloNico.Turnos;

import java.util.ArrayList;
import edu.fiuba.algo3.modeloNico.Enemigo.Enemigo;
import edu.fiuba.algo3.modeloNico.Celdas.Unidad;
import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modeloNico.Oleadas;

public class Turno{

	private int turno;

	public Turno(){
		turno = 1;
	}

	public int turnoActual(){
		return turno;
	}

	public void jugarTurno(Mapa mapa, Oleadas oleadas){

		// move enemigos
		mapa.moverEnemigos();

		// defensas atacan mapa
		ArrayList<Unidad> enemigosMuertos = mapa.accionarDefensas();
		

		// instancia enemigos.
		ArrayList<Enemigo> enemigos = oleadas.instanciar(turno);
		
		for (Enemigo enemigo: enemigos){
			mapa.posicionarInicio(enemigo);
		}

		turno+=1;
	}


}