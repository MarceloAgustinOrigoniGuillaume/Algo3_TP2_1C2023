package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

public interface EstadoEstructura {

    public void ejecutarMetodo(Defensa defensa, Mapa mapa);

    public boolean estaActivo();

    //Hace lo que se espera que haga la instancia de EstadoConstruido o EstadoContruyendo.

}
