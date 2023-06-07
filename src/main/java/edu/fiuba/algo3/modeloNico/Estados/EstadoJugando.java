package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modeloNico.Juego;

public class EstadoJugando implements EstadoJuego {
    Juego juego;

    public EstadoJugando(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void ejecutarEstado() {
       // juego.ejecutarTurno();
    }
}
