package edu.fiuba.algo3.modeloNico.Celdas;

public class Tierra extends Celda {

	private Construccion construccion;

    public Tierra(Coordenada coordenada){
    	super(coordenada);
	    tipoCelda = "Tierra";
	    construccion = null;
    }


    public boolean posicionar(Unidad entidad){
    	return false;
    }

    public boolean posicionar(Construccion entidad){
    	if(construccion == null){
    		construccion = entidad;
    		return true;
    	}

    	return false;
    }


}
