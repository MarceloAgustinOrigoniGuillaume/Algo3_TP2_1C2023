package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;

public interface EstadoEstructura {

    public ArrayList<Unidad> ejecutarMetodo(Defensa defensa, ArrayList<Unidad> enemigos);

    public boolean estaActivo();

    //Hace lo que se espera que haga la instancia de EstadoConstruido o EstadoContruyendo.

}
