package edu.fiuba.algo3.modelo.Enemigo.terrestres;

import edu.fiuba.algo3.modelo.Enemigo.SistemaVida;
import edu.fiuba.algo3.modelo.Enemigo.EnemigoConVida;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public abstract class EnemigoTerrestre extends EnemigoConVida implements Monetizable {

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

    @Override
    public void recibirAtaque(int danioRecibido) {
        super.recibirAtaque(danioRecibido);

        if(estaMuerto()){ // agregamos los creditos...
            creditosDados();
        }
    }


    //Pre: -
    //Post: -
    protected void atacarObjeto(Jugador jugador, Mapa mapa) {
        jugador.recibirAtaque(this.ataqueMaximo);

    }

}
