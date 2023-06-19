package edu.fiuba.algo3.modelo.Defensas.torres;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.EstadoConstruyendo;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;

public class TorrePlateada extends Defensa {

    public TorrePlateada(int turnosParaConstruccion) {
        super(new EstadoConstruyendo(turnosParaConstruccion));

        //this.estadoActual = new EstadoConstruyendo(turnosParaConstruccion);
        //this.turnosParaConstruccion = turnosParaConstruccion;
    }
    public TorrePlateada() {
        this(2);
    }

    @Override
    public int costo() {
        return 20;
    }

    public int ataque(){
        return 2;
        //target.recibirAtaque(2); // hace uno de dmg
    }
    public int obtenerRango(){
        return 5;
    }

    @Override
    public void atacar(Enemigo enemigo) {
        enemigo.recibirAtaque(ataque());
    }
}
