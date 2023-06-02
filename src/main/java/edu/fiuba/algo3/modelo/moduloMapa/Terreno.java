package edu.fiuba.algo3.modelo.moduloMapa;


import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloDefensas.Defensa;
import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigo;

public class Terreno implements Parcela{

	private boolean puedeConstruir;
	private Posicion pos;

	private GameEntity ocupante;
	public Terreno(Posicion pos, boolean puedeConstruir){
		this.pos = pos;
		this.puedeConstruir = puedeConstruir;
		ocupante = null;
	}


	public boolean puedePoner(GameEntity entidad){
		return puedeConstruirDefensa();
	}

	private boolean puedeConstruirDefensa(){
		return puedeConstruir && ocupante == null;
	}
	public boolean puedePoner(Defensa defensa){
		return puedeConstruirDefensa();
	}

	public boolean puedePoner(ConstruccionTentativa construccion){
		return true;
	}
	
	public void poner(GameEntity entidad){
		if(puedeConstruirDefensa()){
			ocupante = entidad;
		}
	}

	@Override
	public Posicion posicion() {
		return pos;
	}

	@Override
	public void sacar(Enemigo unidad) {

	}

	public void poner(Defensa defensa){
		if(puedeConstruirDefensa()){
			ocupante = defensa;
		}
	}


	public void poner(ConstruccionTentativa construccion){
		if(puedeConstruirDefensa()){
			ocupante = construccion;
		}
	}



}