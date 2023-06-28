package edu.fiuba.algo3.modelo.Celdas;


import edu.fiuba.algo3.modelo.Celdas.habitantes.ConstruccionesRocoso;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;

public class Rocosa extends CeldaConEnemigos {

    public final static String ROCOSA_TYPE = "Rocoso";

    public Rocosa(){
        super(false);
    }
    @Override
    public String toString(){
        return ROCOSA_TYPE;
    }

    public CeldaDescriptor describe(){
        return new CeldaDescriptor( ROCOSA_TYPE, describirEnemigos());
    }
}
