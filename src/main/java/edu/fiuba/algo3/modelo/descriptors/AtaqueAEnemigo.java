package edu.fiuba.algo3.modelo.descriptors;

public class AtaqueAEnemigo extends AttackDescriptor{
    

    private static String parseUrl(String enemigo,String atacante){

    	// fijate algo del tipo de torre?
    	return "AtaqueTorre.wav";
    }
    public AtaqueAEnemigo(String enemigo,String atacante){
        super(parseUrl(enemigo,atacante));
    }

    public AtaqueAEnemigo(){
        super("AtaqueTrampa.wav");
        // por defecto si no se pasa parametros es la trampa.
    }
}

