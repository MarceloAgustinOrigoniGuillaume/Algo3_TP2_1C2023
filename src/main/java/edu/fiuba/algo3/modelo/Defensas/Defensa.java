package edu.fiuba.algo3.modelo.Defensas;
import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

public abstract class Defensa implements Estructura {

    protected EstadoEstructura estadoActual;
    //protected int turnosParaConstruccion;

    public Defensa(EstadoEstructura estado_inicial){
        estadoActual = estado_inicial;
    }

    public void finalizarConstruccion(){

        this.estadoActual = new EstadoConstruido();

    }

    public ArrayList<Unidad> accionar(Mapa mapa , Coordenada posicion){
        return estadoActual.ejecutarMetodo(this, mapa, posicion);
    }

    public boolean estaActiva() {
        return estadoActual.estaActivo();
    }

    public abstract int obtenerRango();

    public abstract int ataque();

    public abstract void atacar(Unidad enemigo);


    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }
}
