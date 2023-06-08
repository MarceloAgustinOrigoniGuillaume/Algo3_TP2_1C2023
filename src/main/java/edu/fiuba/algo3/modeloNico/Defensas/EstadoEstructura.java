package edu.fiuba.algo3.modeloNico.Defensas;

import edu.fiuba.algo3.modeloNico.Mapa.Mapa;

public interface EstadoEstructura {

    public void ejecutarMetodo(Defensa defensa, Mapa mapa);

    public boolean estaActivo();

    //Hace lo que se espera que haga la instancia de EstadoConstruido o EstadoContruyendo.

}
