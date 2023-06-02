package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigo;
import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigos;

public class EstadoJuego {
    Enemigos enemigos;
    Jugador jugador;

    public EstadoJuego(Enemigos enemigo, Jugador jugador) {
        this.enemigos = enemigo;
        this.jugador = jugador;
    }

    public boolean termino() {
        return true;
    }

    public boolean ganoJugador() {
        return jugador.obtenerVida()>0;
    }
}
