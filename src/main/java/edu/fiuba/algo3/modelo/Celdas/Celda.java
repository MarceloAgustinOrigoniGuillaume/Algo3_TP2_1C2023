package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;

public interface Celda {
    Coordenada posicion();
    boolean posicionar(Construccion construccion);
    boolean posicionar(Unidad unidad);
    void sacarTodos();
    ArrayList<Unidad>  atacar(ArrayList<Unidad> unidades);
}
