package edu.fiuba.algo3.modelo.descriptors;

import java.util.ArrayList;

public class EnemigoConVidaDescriptor extends EnemigoDescriptor{

	private String vida;

    public EnemigoConVidaDescriptor(String nombre, String tipo,String velocidad, String vida,String descripcion){
        super(nombre, tipo ,velocidad,descripcion);
        this.vida = vida;
    }
    @Override
    public String infoStats(){
        String res =super.infoStats();
        res+= "\n"+"vida: "+vida;
        return res;
    }

}

