package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.modelo.Celdas.habitantes.ConstruccionesTierra;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public class Tierra extends Celda {

    public final static String TIERRA_TYPE = "Tierra";
	
    public Tierra(){
        super(false, new ConstruccionesTierra());
    }

    @Override
    public String toString(){
        return TIERRA_TYPE;
    }

}
