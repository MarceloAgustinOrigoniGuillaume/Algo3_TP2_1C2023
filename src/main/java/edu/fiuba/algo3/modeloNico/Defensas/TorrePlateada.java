package edu.fiuba.algo3.modeloNico.Defensas;

import edu.fiuba.algo3.modeloNico.Celdas.SistemaVida;

public class TorrePlateada extends Defensa {

    public TorrePlateada(int turnosParaConstruccion) {

        this.turnosParaConstruccion = turnosParaConstruccion;
        this.estadoActual = new EstadoConstruyendo(turnosParaConstruccion);
    }
    public TorrePlateada() {
        this(2);
    }
    @Override
    public int costo() {
        return 20;
    }

    public void atacar(SistemaVida target){
        target.recibirAtaque(2); // hace uno de dmg
    }

    public int obtenerRango(){
        return 5;
    }

}
