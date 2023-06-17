package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

public abstract class Celda {

    private Coordenada coordenada;
    protected Habitantes habitantes;

    public Celda(Coordenada pos, Habitantes habitantes){
    	this.coordenada = pos;
    	this.habitantes = habitantes;
    }

    public Coordenada posicion(){
    	return coordenada;
    }

    public boolean posicionar(Posicionable posicionable){
    	return posicionable.posicionarEn(habitantes);
    }

    public void sacar(Posicionable posicionable){
    	habitantes.sacar(posicionable);
    }

    public void clear(){
    	habitantes.clear();
    }

    public abstract ArrayList<Unidad> accionarEstructuras(Mapa mapa);
    
    public  void accionarUnidades(Mapa mapa){
        habitantes.accionarUnidades(mapa, coordenada);
    }

    public boolean recibirAtaque(Ataque ataque){
    	return habitantes.recibirAtaque(ataque);
    }

    public CeldaDescriptor describe(){
    	return new CeldaDescriptor( this.toString() , habitantes.cantidadUnidades());
    }

    //ArrayList<Unidad>  atacar(ArrayList<Unidad> unidades);
    //void sacarUnidad(Unidad unidad);

}
