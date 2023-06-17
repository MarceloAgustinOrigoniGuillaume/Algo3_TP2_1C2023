package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public class Trampa extends Defensa {

    public Trampa() {
        super(new EstadoConstruido());
    }

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
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
    public void atacar(Unidad enemigo) {
        enemigo.reducirVelocidad();
    }

    @Override
    public int ataque() {
        return 0;
    }
}
