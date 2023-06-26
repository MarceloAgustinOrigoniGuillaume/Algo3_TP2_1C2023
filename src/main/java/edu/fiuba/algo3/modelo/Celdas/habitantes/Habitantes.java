package edu.fiuba.algo3.modelo.Celdas.habitantes;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.EnemigoAereo;
import edu.fiuba.algo3.modelo.descriptors.EnemigosDescriptor;


public class Habitantes {
	private ArrayList<Enemigo> enemigos;
	private boolean habilitarTodos;

	public Habitantes(boolean habilitarTodos){
		this.habilitarTodos = habilitarTodos;
		enemigos = new ArrayList<>();
	}

	public Habitantes(){
		this(true);
	}

	// se observa  que Habitantes guarda cualquier Enemigo si una implementacion
	// le dice guarda. La implementacion se encarga de filtrar quien puede.
	protected boolean guardaUnidad(Enemigo unidad){ 
		enemigos.add(unidad);
		return true;
	}

	//Pre: Por default solo se puede guardar Unidades en pasarela.
	//Post: -
	public boolean guardar(Enemigo unidad){
		return habilitarTodos && guardaUnidad(unidad); 
	}
	
	// diferenciamos entre aereo y uno general para posicionar.
	public boolean guardar(EnemigoAereo aereo){
		return guardaUnidad(aereo); 
	}

	public int cantidadUnidades(){
		return enemigos.size();
	}

    public void sacar(Enemigo enemigo){
    	if(enemigos.contains(enemigo)){
    		enemigos.remove(enemigo);
    	}
    }

    // dice a la defensa que ataque a los enemigos,
	public boolean recibirAtaque(Defensa ataque){
		return ataque.atacar(enemigos);
	}

	public ArrayList<Enemigo> popMuertos(){ //Se fija quien esta muerto, los remueve y los devuelve

		ArrayList<Enemigo> muertos = new ArrayList<>();
		for (Enemigo enemigo: new ArrayList<Enemigo>(enemigos)){

			if(enemigo.estaMuerto()){
				muertos.add(enemigo);
				enemigos.remove(enemigo);
			}
		}
		return muertos;
	}

	public void accionarEnemigos(Mapa mapa, Jugador jugador, Coordenada desde){
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

	public EnemigosDescriptor describir(){
		EnemigosDescriptor descriptor = new EnemigosDescriptor();

		for(Enemigo enemigo : enemigos){
			descriptor.agregarEnemigo(enemigo);
		}
		return descriptor;
	}
}
