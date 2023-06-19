package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public interface Movible {
    boolean moverse(Mapa mapa, Coordenada posicion);
}
