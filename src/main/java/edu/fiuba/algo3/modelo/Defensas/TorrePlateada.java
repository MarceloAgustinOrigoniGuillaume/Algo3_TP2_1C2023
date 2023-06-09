package edu.fiuba.algo3.modelo.Defensas;

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

    public int ataque(){
        return 2;
        //target.recibirAtaque(2); // hace uno de dmg
    }

    public int obtenerRango(){
        return 5;
    }

}
