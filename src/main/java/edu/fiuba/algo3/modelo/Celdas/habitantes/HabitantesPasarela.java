package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Celdas.Unidad;

public class HabitantesPasarela extends HabitantesConstruccion {


	public boolean guardar(Trampa trampa){ // solo puede guardar trampas
		return super.guardaConstruccion(trampa);
	}

	public boolean guardar(Unidad unidad){ // pasarela puede guardar cualquier unidad
		return super.guardaUnidad(unidad);
	}
}
