package edu.fiuba.algo3.modeloNico.Celdas;

public class Tierra implements Celda {

	private Construccion construccion;
    private Coordenada coordenada;


    public Tierra(Coordenada coordenada){
    	this.coordenada = coordenada;
	    construccion = null;
    }

    public Coordenada posicion(){
    	return coordenada;
    }

    public boolean posicionar(Unidad entidad){
    	return false;
    }

    public boolean posicionar(Construccion entidad){
		if (construccion == null) {
			construccion = entidad;
		}
		return construccion == null;

	}
    /*
    public GameEntity obtener(){
    	return construccion;
    }
    */


}
