package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.Construccion;

public class Tierra extends Celda {

    public final static String TIERRA_TYPE = "Tierra";
	
    public Tierra(){
        super(false);
    }




	// puede guardar torres
	public boolean guardar(Construccion torre){
		return guardaConstruccion(torre); 
	}

	// no guarda trampas
	public boolean guardar(Trampa trampa){
		return false; 
	}

	// puede recibir ataques de lechuza
	public boolean recibirAtaqueLechuza(){
		borrarDefensa();
		Logger.info("Defensa fue removida?");
		return true;
	}



    @Override
    public String toString(){
        return TIERRA_TYPE;
    }

}
