package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public abstract class Enemigo implements Ataque, Posicionable, Movible {


    public int velocidad;

    public Enemigo(int velocidad){
        this.velocidad = velocidad;
	}
    //Pre: -
    //Post: -
    public int velocidad(){
        return this.velocidad;
    }
    //Pre: -
    //Post: -


    //Pre: -
    // Post: Le dice a los enemigos que se muevan.
    public boolean moverse(Mapa mapa, Coordenada posicion){
        return mapa.moverEnCaminoTerrestre(this,posicion, velocidad);
    }

    //Pre: -
    // Post: -
    public abstract Enemigo copiar();

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }

    protected abstract void atacarObjeto(Jugador jugador, Mapa mapa);

    public void accionar(Mapa mapa, Jugador jugador, Coordenada coordenada){
        if(moverse(mapa,coordenada)){
            atacarObjeto(jugador, mapa);
        }
    }
}