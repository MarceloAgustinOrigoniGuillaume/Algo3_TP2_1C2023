package edu.fiuba.algo3.modeloNico.Celdas;

public class Pasarela extends Celda{


    public Pasarela(Coordenada coordenada){
    	super(coordenada);
	    tipoCelda = "Pasarela";
    }

    public boolean posicionar(Unidad entidad){
    	return false;
    }

    public boolean posicionar(Construccion entidad){
    	return false;
    }

}
