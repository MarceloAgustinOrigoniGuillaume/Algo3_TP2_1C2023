package edu.fiuba.algo3.modelo.Defensas;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;

public interface EstadoEstructura {

    public void ejecutarMetodo(Defensa defensa, Mapa mapa, Coordenada posicion);
    public boolean estaActivo();

}
