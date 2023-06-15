package edu.fiuba.algo3.modelo.Defensas;

public class Trampa extends Defensa {

    public Trampa() {
        this.turnosParaConstruccion = 0;
        this.estadoActual = new EstadoConstruido();
    }
    @Override
    public int ataque() {
        return 0;
    }

    @Override
    public int obtenerRango() {
        return 0;
    }

    @Override
    public int costo() {
        return 25;
    }
}
