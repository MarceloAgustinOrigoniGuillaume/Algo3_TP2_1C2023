package edu.fiuba.algo3.modelo.Enemigo.subterraneos;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;

public abstract class EnemigoSubterraneo extends Enemigo {

    protected int ataqueMaximo;
    public EnemigoSubterraneo(int velocidad, int ataqueMaximo) {
        super(velocidad);
        this.ataqueMaximo = ataqueMaximo;
    }

    //Pre: -
    //Post: Se usa para calcular si es posible que el jugador pierda a partir de los enemigos actuales.
    @Override
    public int ataqueMaximo() {
        return this.ataqueMaximo;
    }

    public boolean atacadoPorTrampa() {
        if (this.velocidad == 1) {
            return true;
        }
        this.velocidad = this.velocidad / 2;
        return true;
    }
}
