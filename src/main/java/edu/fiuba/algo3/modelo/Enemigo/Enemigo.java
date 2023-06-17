package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.Logger;

public abstract class Enemigo implements Unidad {

	protected int vida;
	public Enemigo(int vida){
		this.vida = vida;
	}


    public boolean estaMuerto(){
        return vida <= 0;
    }

    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info(" El daño recibido es: "+danioRecibido);

    }

	public abstract Enemigo copiar();

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }

	public abstract void incrementarContadorDePasos();


    public int ataque(Mapa mapa){
    	return 0;
    }

	public int ataque(){
		return 0;
	}

}

/*
 aca me pasa lo mismo que con Defensa y Estructura, me parece al pedo tener Enemigo y Unidad separado,
  puede ir todo junto.
*/
