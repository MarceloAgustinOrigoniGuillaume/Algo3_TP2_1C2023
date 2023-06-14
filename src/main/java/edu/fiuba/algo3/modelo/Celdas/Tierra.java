package edu.fiuba.algo3.modelo.Celdas;

import java.util.ArrayList;

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
            return true;
		}
        return false;
	}

    public void atacar(SistemaVida target){

        if(construccion != null){
            target.recibirAtaque(construccion.ataque()) ;
        }
    }


    public ArrayList<Coordenada> obtenerEnRango(ArrayList<Coordenada> targets){
        if(construccion != null){

            return coordenada.obtenerEnRango(targets, construccion.obtenerRango());
        }

        return new ArrayList<Coordenada>();

    }

    @Override
    public String toString(){
        return "Tierra";
    }
}
