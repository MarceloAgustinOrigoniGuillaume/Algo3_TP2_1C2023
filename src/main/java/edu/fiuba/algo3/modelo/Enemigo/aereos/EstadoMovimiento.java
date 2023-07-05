package edu.fiuba.algo3.modelo.Enemigo.aereos;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public interface EstadoMovimiento {
    boolean ejecutarEstado(Mapa mapa, Coordenada posicion);
}