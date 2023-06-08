package edu.fiuba.algo3.modeloNico.Celdas;

public class Rocosa implements Celda {

    private Coordenada coordenada;

    public Rocosa(Coordenada coordenada){
    	this.coordenada = coordenada;
    }

    public Coordenada posicion(){
    	return coordenada;
    }


    public boolean posicionar(Unidad entidad){
    	return false;
    }

    public boolean posicionar(Construccion entidad){
    	return false;
    }

    /*
    public GameEntity obtener(){
    	return null;
    }
    */


}
