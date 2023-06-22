package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Trampa;

public class ConstruccionesPasarela extends HabitantesConstruccion {

	public ConstruccionesPasarela(){
		super();
	}

	// puede guardar Trampas
	public boolean guardar(Trampa trampa){
		return guardaConstruccion(trampa); // por default Habitantes no podria guardar nada... cada implementacion sobreescribira
	}

	// no puede guardar torres
	public boolean guardar(Construccion torre){
		return false; 
	}

	// No recibe ataques de lechuza, trampa no lo hace.
	public boolean recibirAtaqueLechuza(){
		return false;
	}
	
}
