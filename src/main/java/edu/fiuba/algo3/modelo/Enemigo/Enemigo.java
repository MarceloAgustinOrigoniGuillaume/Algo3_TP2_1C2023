package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Billetera;
import edu.fiuba.algo3.modelo.Celdas.Ataque;
import edu.fiuba.algo3.modelo.Celdas.SistemaVida;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.Logger;

public abstract class Enemigo implements Ataque, SistemaVida, Posicionable, Monetizable, Movible {

    protected int vida;
    public int velocidad;

    public Enemigo(int vida, int velocidad){
		this.vida = vida;
        this.velocidad = velocidad;
	}
    //Pre: -
    //Post: -
    public int velocidad(){
        return this.velocidad;
    }
    //Pre: -
    //Post: -
    public boolean estaMuerto(){
        return vida <= 0;
    }

    //Pre: -
    // Post: Le dice a los enemigos que se muevan.
    public boolean moverse(Mapa mapa, Coordenada posicion){
        return mapa.moverEnCaminoTerrestre(this,posicion, velocidad);
    }

    //Pre: -
    // Post: -
    public abstract Enemigo copiar();

    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        if(this.vida == 0){
            this.creditosDados();
        }
        Logger.info(" El daño recibido es: "+danioRecibido);
    }

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