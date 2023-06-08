package edu.fiuba.algo3.modeloNico.Celdas;

public class Tierra extends Celda {


    public Tierra(Coordenada coordenada){
    	super(coordenada);
	    tipoCelda = "Tierra";
    }


    public boolean posicionar(Unidad entidad){
    	return false;
    }

    public boolean posicionar(Construccion entidad){
    	return false;
    }


}
