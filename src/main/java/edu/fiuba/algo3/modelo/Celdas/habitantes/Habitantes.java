package edu.fiuba.algo3.modelo.Celdas.habitantes;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Celdas.Ataque;
import edu.fiuba.algo3.modelo.Celdas.Construccion;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.EnemigoAereo;
import edu.fiuba.algo3.modelo.Defensas.Trampa;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

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

	public boolean guardar(Enemigo unidad){
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

	public int cantidadUnidades(){
		return unidades.size();
	}

    public void sacar(Posicionable posicionable){
    	if(unidades.contains(posicionable)){
    		unidades.remove(posicionable);
    	}
    }
    public void clear(){
    	unidades.clear();
    }


	public boolean recibirAtaque(Ataque ataque){
		//ArrayList<Unidad> muertos = new ArrayList<>();
		// recibilo... todabia sin implementar

		return false;
	}


	public void accionarUnidades(Mapa mapa, Coordenada desde){
		for(Unidad unidad: new ArrayList<Unidad>(unidades)){
			unidad.accionar(mapa,desde);
		}
	}

	public ArrayList<Unidad> accionarEstructuras(Mapa mapa, Coordenada desde){
		return null;
	}


}
