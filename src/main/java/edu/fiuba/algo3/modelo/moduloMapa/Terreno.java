package edu.fiuba.algo3.modelo.moduloMapa;



public class Terreno implements Parcela{

	private boolean puedeConstruir;
	private Posicion pos;

	private Defensa ocupante;
	public Terreno(Posicion pos, boolean puedeConstruir){
		this.pos = pos;
		this.puedeConstruir = puedeConstruir;
		ocupante = null;
	}


	public boolean puedePoner(GameEntity entidad){
		return false;
	}

	private boolean puedeConstruirDefensa(){
		return puedeConstruir && ocupante == null;
	}
	public boolean puedePoner(Defensa defensa){
		return puedeConstruirDefensa();
	}


	
	public void poner(GameEntity entidad){
		// tirar Error?
	}

	public void poner(Defensa defensa){
		if(puedeConstruirDefensa()){
			ocupante = defensa;
		}
	}



}