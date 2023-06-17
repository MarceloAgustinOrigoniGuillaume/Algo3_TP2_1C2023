package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Enemigo.Lechuza;

public class HabitantesTerreno extends HabitantesConstruccion {

	public boolean guardar(Lechuza lechuza){ // cualquier terreno podria guardar lechuzas...
		return super.guardaUnidad(lechuza);
	}
}
