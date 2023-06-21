package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
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

    //Pre: -
    //Post: -
    public int obtenerDamagePosible(int contadorActual){
        return this.habitantes.obtenerDamagePosible(contadorActual);
    }

    public boolean posicionar(Posicionable posicionable){ //PROVISORIO
    	return posicionable.posicionarEn(habitantes);
    }
    public void accionarEstructuras(Mapa mapa){
        habitantes.accionarEstructuras(mapa, this.posicion());
    }

    public void sacar(Posicionable posicionable){
    	habitantes.sacar(posicionable);
    }

    public  void moverUnidades(Mapa mapa, Jugador jugador){
        habitantes.moverUnidades(mapa, jugador,coordenada);
    }

    public boolean recibirAtaque(Defensa ataque){
    	return habitantes.recibirAtaque(ataque);
    }

    public void clear(){
        habitantes.clear();
    }

    public CeldaDescriptor describe(){
    	return new CeldaDescriptor( this.toString() , habitantes.cantidadUnidades());
    }
}
