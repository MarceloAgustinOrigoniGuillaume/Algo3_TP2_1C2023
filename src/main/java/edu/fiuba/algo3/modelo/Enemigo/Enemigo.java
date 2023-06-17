package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.Logger;

public abstract class Enemigo implements Unidad {

    protected int vida;
    protected int velocidad;
	public Enemigo(int vida, int velocidad){
		this.vida = vida;
        this.velocidad = velocidad;
	}

    public int velocidad(){
        return this.velocidad;
    }

    public boolean estaMuerto(){
        return vida <= 0;
    }

    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info(" El daño recibido es: "+danioRecibido);

    }





    public int ataque(Mapa mapa){
    	return 0;
    }

	public int ataque(){
		return 0;
	}

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }


    protected void moverse(Mapa mapa, Coordenada posicion){
        mapa.moverEnCamino(this,posicion, velocidad);
    }

    public void accionar(Mapa mapa, Coordenada posicion){
        moverse(mapa, posicion);
    }



	public abstract Enemigo copiar();
	public abstract void incrementarContadorDePasos();
}

/*
 aca me pasa lo mismo que con Defensa y Estructura, me parece al pedo tener Enemigo y Unidad separado,
  puede ir todo junto.
*/
