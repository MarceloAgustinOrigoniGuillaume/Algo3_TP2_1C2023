package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesConstruccion;

public abstract class Celda {

    //private Coordenada coordenada;
    protected Habitantes habitantes;
    protected HabitantesConstruccion construcciones;

    public Celda(Coordenada pos, Habitantes habitantes,HabitantesConstruccion construcciones){
        //this.coordenada = pos;
        this.habitantes = habitantes;
        this.construcciones = construcciones;
    }

    //public Coordenada posicion(){
    //    return coordenada;
    //}

    public Habitantes enemigos(){
        return habitantes;
    }

    public HabitantesConstruccion defensas(){
        return construcciones;
    }

    public void accionarEstructuras(Mapa mapa, Coordenada posicion){
        construcciones.accionarEstructuras(mapa, posicion);
    }

    public  void accionarEnemigos(Mapa mapa, Jugador jugador, Coordenada posicion){
        habitantes.accionarEnemigos(mapa, jugador, posicion);
    }

    //Pre: -
    //Post: Describe a la celda para la ui... pone todos los datos necesarios
    public CeldaDescriptor describe(){
        return new CeldaDescriptor( this.toString() , habitantes.cantidadUnidades(), construcciones.describir(), habitantes.describir());
    }
}
