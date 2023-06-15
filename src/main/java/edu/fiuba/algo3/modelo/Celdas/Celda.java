package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

public interface Celda {
    Coordenada posicion();
    boolean posicionar(Construccion construccion);
    boolean posicionar(Unidad unidad);
    void sacarTodos();
    void atacar(SistemaVida target, Mapa mapa);
}
