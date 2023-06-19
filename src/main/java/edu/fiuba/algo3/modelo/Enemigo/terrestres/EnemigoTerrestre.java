package edu.fiuba.algo3.modelo.Enemigo.terrestres;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public abstract class EnemigoTerrestre extends Enemigo {


    private int ataqueMaximo;

    public EnemigoTerrestre(int vida, int velocidad, int ataqueMaximo) {
        super(vida, velocidad);
        this.ataqueMaximo = ataqueMaximo;
    }

    //Pre: -
    //Post: Se usa para calcular si es posible que el jugador pierda a partir de los enemigos actuales.
    @Override
    public int ataqueMaximo() {
        return this.ataqueMaximo;
    }

    public void reducirVelocidad(){
        this.velocidad = (int)Math.floor(this.velocidad / 2);
    }

    //Pre: -
    //Post: -
    protected void atacarObjeto(Jugador jugador, Mapa mapa) {
        jugador.recibirAtaque(this.ataqueMaximo);

    }

    @Override
    public Enemigo copiar() {
        return null;
    }

}
