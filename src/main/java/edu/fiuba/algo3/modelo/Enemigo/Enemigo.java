package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Celdas.Ataque;
import edu.fiuba.algo3.modelo.Celdas.SistemaVida;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.Logger;

public abstract class Enemigo implements Ataque, SistemaVida, Posicionable, Monetizable {

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
    protected void moverse(Mapa mapa, Coordenada posicion){
        mapa.moverEnCamino(this,posicion, velocidad);
    }

    //Pre: -
    // Post: -
    public abstract Enemigo copiar();

    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info(" El daño recibido es: "+danioRecibido);
    }

	public int ataque(){
		return 0;
	}

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }

    public void accionar(Mapa mapa, Coordenada coordenada){
        // ESTE METODO ES EL DE LA INTERFAZ DE POSICIONABLE
        // NO LO SAQUEN SOLO PORQUE AHORA SOLO MUEVA
        // EN ALGUN MOMENTO DEBERA ATACAR

        moverse(mapa,coordenada); 
    }

}

/*
 aca me pasa lo mismo que con Defensa y Estructura, me parece al pedo tener Enemigo y Unidad separado,
  puede ir todo junto.

  ... Es para evitar dependencias circulares... 
  pero bueno si quieren sacarlo saquenlo si despues aparecen problemas con eso. Ya sabran
*/
