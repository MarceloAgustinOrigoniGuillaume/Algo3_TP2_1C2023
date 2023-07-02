package edu.fiuba.algo3.modelo.Celdas;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.EnemigoAereo;
import edu.fiuba.algo3.modelo.descriptors.EnemigosDescriptor;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;


public class CeldaBase implements CeldaConEnemigos{
	private ArrayList<Enemigo> enemigos = new ArrayList<>();
	private boolean habilitarTodos;

	public CeldaBase(boolean habilitarTodos){
		this.habilitarTodos = habilitarTodos;
	}

	public CeldaBase(){
		this(true);
	}

	// se observa  que CeldaBase guarda cualquier Enemigo si una implementacion
	// le dice guarda. Los metodos publicos filtran
	protected boolean guardaUnidad(Enemigo unidad){ 
		enemigos.add(unidad);
		return true;
	}

	//Pre: Por default solo se puede guardar Unidades en pasarela. habilitarTodos es false.
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
	public boolean recibirAtaque(Defensa ataque, OnAttackListener listener){
		return ataque.atacar(enemigos, listener);
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

	// descripcion
	public EnemigosDescriptor describirEnemigos(){
		return new EnemigosDescriptor(enemigos);
	}

    public CeldaDescriptor describe(){
        return new CeldaDescriptor( this.toString(), describirEnemigos());
    }

}
