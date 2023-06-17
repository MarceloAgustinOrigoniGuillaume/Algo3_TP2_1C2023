package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Celdas.Construccion;

public abstract class HabitantesConstruccion extends Habitantes{

	private Construccion construccionGuardada;
	public HabitantesConstruccion(){
		construccionGuardada = null;
	}

	private boolean hayEspacio(){
		return construccionGuardada == null;
	}

	protected boolean guardaConstruccion(Construccion construccion){
		if(!hayEspacio()){
			return false;
		}

		construccionGuardada = construccion;
		return true;
	}
}
