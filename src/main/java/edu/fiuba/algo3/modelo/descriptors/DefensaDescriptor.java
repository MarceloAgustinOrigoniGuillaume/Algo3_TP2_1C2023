package edu.fiuba.algo3.modelo.descriptors;

import edu.fiuba.algo3.modelo.Defensas.Defensa;

public class DefensaDescriptor {

    private String defensa;

    public DefensaDescriptor(String defensa){
        this.defensa = defensa;
    }
    public String tipo(){
        return defensa;
    }
}
