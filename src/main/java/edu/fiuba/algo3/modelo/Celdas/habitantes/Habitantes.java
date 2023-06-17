package edu.fiuba.algo3.modelo.Celdas.habitantes;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.Unidad;

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









	public boolean guardar(Posicionable posicionable){
		return false; // por default Habitantes no podria guardar nada... cada implementacion sobreescribira
	}

	//public ArrayList<Posicionable> atacadosPor(){

	//}




}
