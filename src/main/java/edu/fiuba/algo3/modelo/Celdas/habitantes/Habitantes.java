package edu.fiuba.algo3.modelo.Celdas.habitantes;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Celdas.Construccion;
import edu.fiuba.algo3.modelo.Enemigo.EnemigoAereo;
import edu.fiuba.algo3.modelo.Defensas.Trampa;

public abstract class Habitantes {


	// por ahora todos las celdad/tipos habitantes deberian poder contener enemigos...
	// por lo que la logica de su guardado ira aca...
	// no asi con construcciones, rocoso no necesitaria eso. Por eso se creo HabitantesConstruccion

	private ArrayList<Unidad> unidades;

	public Habitantes(){
		unidades = new ArrayList<>();
	}

	// se observa  que Habitantes guarda cualquier unidad si una implementacion
	// le dice guarda. La implementacion se encarga de filtrar quien puede.
	protected boolean guardaUnidad(Unidad unidad){ 
		unidades.add(unidad);
		return true;
	}





	// por default solo se puede guardar Unidades en pasarela

	public boolean guardar(Unidad unidad){
		return guardaUnidad(unidad); 
	}

	public boolean guardar(EnemigoAereo aereo){
		return guardaUnidad(aereo); 
	}

	public boolean guardar(Construccion construccion){
		return false; // por default Habitantes no podria guardar nada... cada implementacion sobreescribira
	}


	public boolean guardar(Trampa trampa){
		return false; // por default Habitantes no podria guardar nada... cada implementacion sobreescribira
	}

	//public ArrayList<Posicionable> atacadosPor(){

	//}




}
