package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Trampa extends Defensa {

    public Trampa() {
        this.turnosParaConstruccion = 0;
        this.estadoActual = new EstadoConstruido();
    }

    @Override
    public int obtenerRango() {
        return 0;
    }

    @Override
    public int costo() {
        return 25;
    }

    @Override
    public int ataque(Mapa mapa) {
        return 0;
    }

    @Override
    public int ataque() {
        return 0;
    }
}
