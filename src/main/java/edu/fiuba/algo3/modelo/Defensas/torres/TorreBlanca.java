package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class TorreBlanca extends Defensa {


    public TorreBlanca(int turnosParaConstruccion) {
        //this.turnosParaConstruccion = turnosParaConstruccion;
        super(new EstadoConstruyendo(turnosParaConstruccion));
    }

    public TorreBlanca() {
        this(1);
    }

    @Override
    public int costo() {
        return 10;
    }

    public int ataque(){
        return 1;
        //target.recibirAtaque(1); // hace uno de dmg
    }

    public int obtenerRango(){
        return 3;
    }
    @Override
    public void atacar(Unidad enemigo) {
        enemigo.recibirAtaque(ataque());
    }

}