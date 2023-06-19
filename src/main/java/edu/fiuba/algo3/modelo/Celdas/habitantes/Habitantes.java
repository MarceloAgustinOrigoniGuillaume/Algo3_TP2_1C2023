package edu.fiuba.algo3.modelo.Celdas.habitantes;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Celdas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.EnemigoAereo;
import edu.fiuba.algo3.modelo.Defensas.Trampa;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public abstract class Habitantes {


	// por ahora todos las celdad/tipos habitantes deberian poder contener enemigos...
	// por lo que la logica de su guardado ira aca...
	// no asi con construcciones, rocoso no necesitaria eso. Por eso se creo HabitantesConstruccion

	private ArrayList<Enemigo> enemigos;

	public Habitantes(){
		enemigos = new ArrayList<>();
	}

	// se observa  que Habitantes guarda cualquier Enemigo si una implementacion
	// le dice guarda. La implementacion se encarga de filtrar quien puede.
	protected boolean guardaUnidad(Enemigo unidad){ 
		enemigos.add(unidad);
		return true;
	}

	public boolean guardar(Trampa trampa){
		return false; // por default Habitantes no podria guardar nada... cada implementacion sobreescribira
	}

	//Pre: Por default solo se puede guardar Unidades en pasarela.
	//Post: -
	public boolean guardar(Enemigo unidad){
		return guardaUnidad(unidad); 
	}
	public boolean guardar(EnemigoAereo aereo){
		return guardaUnidad(aereo); 
	}

	//Pre: Por default Habitantes no podria guardar nada... cada implementacion sobreescribirá.
	//Post: -
	public boolean guardar(Construccion construccion){
		return false;
	}

	public int cantidadUnidades(){
		return enemigos.size();
	}

    public void sacar(Posicionable posicionable){
    	if(enemigos.contains(posicionable)){
    		enemigos.remove(posicionable);
    	}
    }
    public void clear(){
    	enemigos.clear();
    }


	public boolean recibirAtaque(Defensa ataque){
		//ArrayList<Enemigo> muertos = new ArrayList<>();
		// recibilo... todabia sin implementar

		return false;
	}

	public void moverUnidades(Mapa mapa, Jugador jugador, Coordenada desde){
		for(Enemigo enemigo: new ArrayList<Enemigo>(enemigos)){
			enemigo.accionar(mapa,jugador, desde);
		}
	}

	//Pre: -
	//Post: -
	public int obtenerDamagePosible(int contadorActual){
		for(Enemigo enemigo: new ArrayList<Enemigo>(enemigos)){
			contadorActual += enemigo.ataqueMaximo();
		}
		return contadorActual;
	}


	public void accionarEstructuras(Mapa mapa, Coordenada desde){
		
	}


}
