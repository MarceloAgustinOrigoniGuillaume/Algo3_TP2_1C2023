package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modeloNico.AlgoDefense;

public class EstadoJugando implements EstadoJuego {
    AlgoDefense juego;

    public EstadoJugando(AlgoDefense juego) {
        this.juego = juego;
    }

    @Override
    public void ejecutarEstado() {
       // juego.ejecutarTurno();
    }
}
