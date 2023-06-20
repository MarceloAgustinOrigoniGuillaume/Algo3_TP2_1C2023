package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Celdas.Construccion;

public class HabitantesTierra extends HabitantesTerreno {

	//Pre: -
	//Post: Se guardan las torres. Las trampas tienen su metodo.
	public boolean guardar(Construccion construccion){
		return guardaConstruccion(construccion);
	}

}
