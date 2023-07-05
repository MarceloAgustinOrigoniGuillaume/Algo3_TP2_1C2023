package edu.fiuba.algo3.modelo.Celdas;


import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;

public class Rocosa extends CeldaBase {

    public final static String ROCOSA_TYPE = "Rocoso";

    public Rocosa(){
        super(false);
    }
    @Override
    public String toString(){
        return ROCOSA_TYPE;
    }
}
