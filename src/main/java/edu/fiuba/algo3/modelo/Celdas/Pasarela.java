package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

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

    @Override
    public void sacarTodos(){
        unidades.clear();
    }

    public void sacar(Unidad unidad){
        unidades.remove(unidad);
    }

    public ArrayList<Unidad> atacar(ArrayList<Unidad> unidades){
        return null;
    }

    @Override
    public void sacarUnidad(Unidad unidad) {
        return;
    }

    @Override
    public String toString(){
        return "Pasarela";
    }

}
