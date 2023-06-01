package edu.fiuba.algo3.modelo.moduloMapa;


import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigo;

public interface Parcela{
	boolean puedePoner(GameEntity entidad);
	void poner(GameEntity entidad);
	
	Posicion posicion();

	void sacar(Enemigo unidad);
}