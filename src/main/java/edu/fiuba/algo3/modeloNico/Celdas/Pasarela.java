package edu.fiuba.algo3.modeloNico.Celdas;

import java.util.ArrayList;

public class Pasarela implements Celda{

    private Coordenada coordenada;
    private ArrayList<Unidad> unidades;
    public Pasarela(Coordenada coordenada){
    	this.coordenada = coordenada;
    	unidades = new ArrayList<>();
    }

    public Coordenada posicion(){
    	return coordenada;
    }


    public boolean posicionar(Unidad entidad){
    	
    	unidades.add(entidad);

    	return true;
    }

    public boolean posicionar(Construccion entidad){
    	return false;
    }

    
    public ArrayList<Unidad> obtenerUnidades(){
    	return new ArrayList<>(unidades);
    }

    public void sacarTodos(){
    	unidades.clear();
    }

}
