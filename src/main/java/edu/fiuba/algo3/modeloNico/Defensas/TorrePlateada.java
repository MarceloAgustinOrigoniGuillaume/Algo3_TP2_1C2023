package edu.fiuba.algo3.modeloNico.Defensas;


public class TorrePlateada extends Defensa {

    public TorrePlateada(int turnosParaConstruccion) {

        this.turnosParaConstruccion = turnosParaConstruccion;
        this.estadoActual = new EstadoConstruyendo(turnosParaConstruccion);
    }

    @Override
    public int costo() {
        return 20;
    }


}
