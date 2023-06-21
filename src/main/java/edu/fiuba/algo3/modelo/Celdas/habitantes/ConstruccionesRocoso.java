package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Trampa;

public class ConstruccionesRocoso extends HabitantesConstruccion {

	public ConstruccionesRocoso(){
		super();
	}

	// no puede guardar torres
	public boolean guardar(Construccion torre){
		return false; 
	}

	// no guarda trampas
	public boolean guardar(Trampa trampa){
		return false; 
	}

	// No recibe ataques de lechuza, no tiene construcciones.
	public boolean recibirAtaqueLechuza(){
		return false;
	}

}
