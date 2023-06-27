package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Trampa;

import edu.fiuba.algo3.Logger;

public class ConstruccionesTierra extends HabitantesConstruccion{

	public ConstruccionesTierra(){
		super();
	}

	// puede guardar torres
	public boolean guardar(Construccion torre){
		return guardaConstruccion(torre); 
	}

	// no guarda trampas
	public boolean guardar(Trampa trampa){
		return false; 
	}

	// puede recibir ataques de lechuza
	public boolean recibirAtaqueLechuza(){
		clear();
		Logger.info("Defensa fue removida?");
		return true;
	}
	
}
