package edu.fiuba.algo3.modelo.Defensas;


import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import java.util.ArrayList;

public class EstadoConstruido implements EstadoEstructura{

    @Override
    public void ejecutarMetodo(Defensa defensa, Mapa mapa, Coordenada coordenada){
        coordenada.iterarEnRango( defensa.obtenerRango(),(Coordenada target)->
        { return mapa.atacar(target, defensa);});
    }
    public boolean estaActivo(){
        return true;
    }
}

