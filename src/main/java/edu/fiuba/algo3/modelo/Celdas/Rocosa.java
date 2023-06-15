package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;

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
    public void atacar(SistemaVida target){
    }


    @Override
    public void sacarTodos(){

    }
    public ArrayList<Unidad> atacar(ArrayList<Unidad> unidades){
        return null;
    }
    @Override
    public String toString(){
        return "Rocosa";
    }
}
