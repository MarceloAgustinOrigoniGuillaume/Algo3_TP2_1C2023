package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public abstract class HabitantesConstruccion extends Habitantes{

	private Construccion construccionGuardada;
	public HabitantesConstruccion(){
		construccionGuardada = null;
	}

	private boolean hayEspacio(){
		return construccionGuardada == null;
	}

    public void sacar(Posicionable posicionable){
    	if(construccionGuardada == posicionable){
    		construccionGuardada = null;
    		return;
    	}
    	super.sacar(posicionable);
    }

    public void clear(){
    	construccionGuardada = null;
    }

	protected boolean guardaConstruccion(Construccion construccion){
		if(!hayEspacio()){
			return false;
		}
		construccionGuardada = construccion;
		return true;
	}

	public void accionarEstructuras(Mapa mapa, Coordenada desde){
		if(construccionGuardada != null){
			construccionGuardada.accionar(mapa,desde);
		}
	}

	public boolean recibirAtaque(Defensa ataque){
		if(construccionGuardada != null){
			// intenta defensa reciba ataque?
		}
		return super.recibirAtaque(ataque);
	}
}
