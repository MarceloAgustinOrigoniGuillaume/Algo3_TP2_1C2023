package edu.fiuba.algo3.modelo.descriptors;

import edu.fiuba.algo3.modelo.Defensas.Defensa;

public class DefensaDescriptor {

    private String defensa;

    public DefensaDescriptor(String defensa, boolean estaActiva){
        if(!estaActiva){
        	this.defensa = "construccion.jpg";
        	return;
        }

        if(defensa == "Trampa"){
        	this.defensa = "Trampa.jpg";
        } else{
        	this.defensa = defensa+".png";
        }


    }
    public DefensaDescriptor(){
        this.defensa = null;
    }


    public String rel_image(){
    	if(this.defensa == null){
    		return "";
    	}
        return "defensas/"+defensa; // por ahora siempre la misma ja
    }
}
