package edu.fiuba.algo3.modelo.Defensas;

public class TorreBlanca extends Defensa {


    public TorreBlanca(int turnosParaConstruccion) {

        this.turnosParaConstruccion = turnosParaConstruccion;
        this.estadoActual = new EstadoConstruyendo(turnosParaConstruccion);
    }

    public TorreBlanca() {
        this(1);
    }

    @Override
    public int costo() {
        return 10;
    }

    public int ataque(){
        return 2;
        //target.recibirAtaque(1); // hace uno de dmg
    }

    public int obtenerRango(){
        return 3;
    }

}

/*
 No me queda claro por que aca se creo la clase Defensa,
 cuando ya existe la interfaz Estructura, me parece que se puede combinar ambas.
*/