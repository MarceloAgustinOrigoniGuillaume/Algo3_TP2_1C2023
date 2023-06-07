package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modeloNico.AlgoDefense;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJuego;

public class EstadoInicial implements EstadoJuego {
    private AlgoDefense juego;
    private Lector lector = new LectorMapa();
    public EstadoInicial(AlgoDefense juego) {
        this.juego = juego;
    }

    @Override
    public void ejecutarEstado() {
        this.lector.inicializarMapa();
    }
}
