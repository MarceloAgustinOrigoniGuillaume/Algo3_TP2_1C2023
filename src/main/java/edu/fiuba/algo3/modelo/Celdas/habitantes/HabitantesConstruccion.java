package edu.fiuba.algo3.modelo.Celdas.habitantes;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Celdas.Construccion;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Ataque;

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

	public ArrayList<Unidad> accionarEstructuras(Mapa mapa, Coordenada desde){
		if(construccionGuardada != null){
			return construccionGuardada.accionar(mapa,desde);
		}
		return null;
	}

	public boolean recibirAtaque(Ataque ataque){
		if(construccionGuardada != null){
			// intenta defensa reciba ataque?
			
		}

		return super.recibirAtaque(ataque);
	}


}
