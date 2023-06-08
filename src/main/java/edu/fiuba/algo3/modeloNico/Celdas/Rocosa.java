package edu.fiuba.algo3.modeloNico.Celdas;

public class Rocosa extends Celda {


    public Rocosa(Coordenada coordenada){
    	super(coordenada);
    	tipoCelda = "Rocosa";
    }

    public boolean posicionar(Unidad entidad){
    	return false;
    }

    public boolean posicionar(Construccion entidad){
    	return false;
    }


}
