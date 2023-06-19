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

	private ArrayList<Enemigo> unidades;

	public Habitantes(){
		unidades = new ArrayList<>();
	}

	// se observa  que Habitantes guarda cualquier Enemigo si una implementacion
	// le dice guarda. La implementacion se encarga de filtrar quien puede.
	protected boolean guardaUnidad(Enemigo unidad){ 
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
		//ArrayList<Enemigo> muertos = new ArrayList<>();
		// recibilo... todabia sin implementar

		return false;
	}


	public void accionarUnidades(Mapa mapa, Coordenada desde){
		for(Enemigo unidad: new ArrayList<Enemigo>(unidades)){
			unidad.accionar(mapa,desde);
		}
	}

	public void accionarEstructuras(Mapa mapa, Coordenada desde){
		
	}


}
