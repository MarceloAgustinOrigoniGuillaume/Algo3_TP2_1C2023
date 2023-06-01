package edu.fiuba.algo3.modelo.moduloMapa;


import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigo;

public class Pasarela implements Parcela{

	private Posicion pos;
	public Pasarela(Posicion pos){
		this.pos = pos;
	}


	public boolean puedePoner(GameEntity entidad){
		return false;
	}
	
	public void poner(GameEntity entidad){

	}

	@Override
	public Posicion posicion() {
		return pos;
	}

	@Override
	public void sacar(Enemigo unidad) {

	}

}