package edu.fiuba.algo3.modelo.Celdas.habitantes;



import edu.fiuba.algo3.modelo.Defensas.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.TorrePlateada;


public class HabitantesTierra extends HabitantesTerreno {


	public boolean guardar(TorreBlanca torre){ // solo puede torreBlanca y torrePlateada
		return super.guardaConstruccion(torre);
	}

	public boolean guardar(TorrePlateada torre){ // solo puede torreBlanca y torrePlateada
		return super.guardaConstruccion(torre);
	}
}
