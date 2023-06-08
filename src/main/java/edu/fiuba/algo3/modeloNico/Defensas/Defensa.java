package edu.fiuba.algo3.modeloNico.Defensas;

public abstract class Defensa implements Estructura {

    protected EstadoEstructura estadoActual;
    protected int turnosParaConstruccion;

    public void finalizarConstruccion(){

        this.estadoActual = new EstadoConstruido();

    }

}
