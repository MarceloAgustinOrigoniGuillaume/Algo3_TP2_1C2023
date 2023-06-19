package edu.fiuba.algo3.modelo.Defensas;


import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import java.util.ArrayList;

public class EstadoConstruido implements EstadoEstructura{


    @Override
    public ArrayList<Unidad> ejecutarMetodo(Defensa defensa, Mapa mapa, Coordenada coordenada){

        ArrayList<Unidad> enemigos = new ArrayList<>();        
        coordenada.iterarEnRango( defensa.obtenerRango() , (Coordenada target)->{
            return mapa.atacar(coordenada, defensa);
        });

        return enemigos;

    }
    public boolean estaActivo(){
        return true;
    }
}

