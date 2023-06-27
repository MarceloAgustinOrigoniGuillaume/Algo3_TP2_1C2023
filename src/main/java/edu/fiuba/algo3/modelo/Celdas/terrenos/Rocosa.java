package edu.fiuba.algo3.modelo.Celdas;


import edu.fiuba.algo3.modelo.Celdas.habitantes.ConstruccionesRocoso;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public class Rocosa extends Celda {

    public final static String ROCOSA_TYPE = "Rocoso";

    public Rocosa(){
        super(false , new ConstruccionesRocoso());
    }
    @Override
    public String toString(){
        return ROCOSA_TYPE;
    }
}
