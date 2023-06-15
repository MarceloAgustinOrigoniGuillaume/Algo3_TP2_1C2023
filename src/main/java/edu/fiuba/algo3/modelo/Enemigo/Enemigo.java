package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public interface Enemigo extends Unidad {
	Enemigo copiar();

	void incrementarContadorDePasos();


    int ataque(Mapa mapa);

	int ataque();

}

/*
 aca me pasa lo mismo que con Defensa y Estructura, me parece al pedo tener Enemigo y Unidad separado,
  puede ir todo junto.
*/
