package edu.fiuba.algo3.modeloNico.Celdas;

public abstract class Celda {    
    protected String tipoCelda;

    private Coordenada coordenada;

    public Celda(Coordenada coordenada){
    	this.coordenada = coordenada;

    }

    public Coordenada posicion(){
    	return coordenada;
    }



    public String imprimirTipo() {
        return tipoCelda;
    }

    public abstract boolean posicionar(Construccion construccion);
    public abstract boolean posicionar(Unidad unidad);
}
