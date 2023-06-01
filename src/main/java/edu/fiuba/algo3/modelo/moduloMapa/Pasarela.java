package edu.fiuba.algo3.modelo.moduloMapa;


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

}