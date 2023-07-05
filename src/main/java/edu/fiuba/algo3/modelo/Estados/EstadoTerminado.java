package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.Logger;

public class EstadoTerminado implements EstadoJuego {
    private Juego juego;
    public EstadoTerminado(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void ejecutarEstado() {
        Logger.info("Ejecutar estado con juego finalizado");
    }
}
