package edu.fiuba.algo3.modelo.Celdas.habitantes;

import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Trampa;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;

public abstract class HabitantesConstruccion{

	private Construccion construccionGuardada;
	public HabitantesConstruccion(){
		construccionGuardada = null;
	}

	private boolean hayEspacio(){
		return construccionGuardada == null;
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

	// metodos publicos para el double dispatch
	public abstract boolean guardar(Trampa trampa);
	public abstract boolean guardar(Construccion construccion);
	public abstract boolean recibirAtaqueLechuza();


	// accionar estructuras, acciona a la construccion de tener una.
	public void accionarEstructuras(Mapa mapa, Coordenada desde){
		if(construccionGuardada != null){
			construccionGuardada.accionar(mapa,desde);
		}
	}

	public DefensaDescriptor describir() {

		if(this.construccionGuardada != null){
			return new DefensaDescriptor(this.construccionGuardada.toString(), this.construccionGuardada.estaActiva());
		}
		return new DefensaDescriptor();
	}
}
