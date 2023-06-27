package edu.fiuba.algo3.modelo.Celdas;


import edu.fiuba.algo3.modelo.Celdas.habitantes.ConstruccionesPasarela;
//import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public class Pasarela extends Celda{

    public final static String PASARELA_TYPE = "Pasarela";

    public Pasarela(){
        super(true, new ConstruccionesPasarela());
    }

    @Override
    public String toString(){
        return PASARELA_TYPE;
    }

}
