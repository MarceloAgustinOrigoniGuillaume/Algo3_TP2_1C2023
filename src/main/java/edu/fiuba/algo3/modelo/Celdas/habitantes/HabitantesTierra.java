package edu.fiuba.algo3.modelo.Celdas.habitantes;



import edu.fiuba.algo3.modelo.Celdas.Construccion;


public class HabitantesTierra extends HabitantesTerreno {


	public boolean guardar(Construccion construccion){
		return guardaConstruccion(construccion); // serian las torres... trampas tienen su metodo
	}

}
