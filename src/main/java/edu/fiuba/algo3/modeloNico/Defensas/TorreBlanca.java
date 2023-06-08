package edu.fiuba.algo3.modeloNico.Defensas;

public class TorreBlanca extends Defensa {


    public TorreBlanca(int turnosParaConstruccion) {

        this.turnosParaConstruccion = turnosParaConstruccion;
        this.estadoActual = new EstadoConstruyendo(turnosParaConstruccion);
    }

    @Override
    public int costo() {
        return 10;
    }

}
