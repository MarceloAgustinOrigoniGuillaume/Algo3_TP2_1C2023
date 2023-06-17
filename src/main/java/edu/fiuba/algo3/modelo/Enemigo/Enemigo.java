package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public abstract class Enemigo implements Unidad {
	public abstract Enemigo copiar();

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }

	public abstract void incrementarContadorDePasos();


    public abstract int ataque(Mapa mapa);

	public abstract int ataque();

}

/*
 aca me pasa lo mismo que con Defensa y Estructura, me parece al pedo tener Enemigo y Unidad separado,
  puede ir todo junto.
*/
