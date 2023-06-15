package edu.fiuba.algo3.modelo.Defensas;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public abstract class Defensa implements Estructura {

    protected EstadoEstructura estadoActual;
    protected int turnosParaConstruccion;

    public void finalizarConstruccion(){

        this.estadoActual = new EstadoConstruido();

    }
    public void accionar(Mapa mapa){
        estadoActual.ejecutarMetodo(this, mapa);
    }

    public boolean finalizoContruccion() {
        return estadoActual.estaActivo();
    }

    public abstract int ataque();
}
