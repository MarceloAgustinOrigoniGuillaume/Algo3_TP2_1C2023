package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.SistemaCreditos;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Celdas.CeldaConEnemigos;
import edu.fiuba.algo3.modelo.descriptors.EnemigoDescriptor;

public abstract class Enemigo implements Ataque {

    protected int velocidad;

    public Enemigo(int velocidad){
        this.velocidad = velocidad;
	}
    public int velocidad(){
        return this.velocidad;
    }

    // No es atacado por torre
    public boolean atacadoPorTorre(int dmg){
        return false;
    }

    // por default si es atacado por trampa... Si... se podria
    // hacer un triple dispatch para cumplir perfectamente con 
    // segregacion de interfaz, vale la pena? no lo creo.
    public abstract boolean atacadoPorTrampa();


    // se necesita este metodo para verificar si el enemigo ha de
    // desaparecer de habitantes...
    public boolean estaMuerto(){
        return false;
    }

    // para acreditarse... lo default es que no de creditos.
    // se necesita este metodo para el double dispatch
    public void acreditarseEn(SistemaCreditos sistema){
        return;
    }

    public abstract EnemigoDescriptor describir();

    //Pre: -
    // Post: Le dice a los enemigos que se muevan.
    public boolean moverse(Mapa mapa, Coordenada posicion){
        return mapa.moverEnCaminoTerrestre(this,posicion, velocidad);
    }

    //Pre: -
    // Post: -
    public abstract Enemigo copiar();

    public boolean posicionarEn(CeldaConEnemigos celda){
        return celda.guardar(this);
    }

    protected abstract void atacarObjeto(Jugador jugador, Mapa mapa);

    public void accionar(Mapa mapa, Jugador jugador, Coordenada coordenada){
        //Logger.info("Accionando ",this);
        if(moverse(mapa,coordenada)){
            atacarObjeto(jugador, mapa);
        }
    }
}