package edu.fiuba.algo3.modelo.Defensas;
import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;

public abstract class Defensa implements Estructura {

    protected EstadoEstructura estadoActual;
    protected int turnosParaConstruccion;

    public void finalizarConstruccion(){

        this.estadoActual = new EstadoConstruido();

    }

    public ArrayList<Unidad> accionar(ArrayList<Unidad> enemigos){
        return estadoActual.ejecutarMetodo(this, enemigos);
    }

    public boolean estaActiva() {
        return estadoActual.estaActivo();
    }
}
