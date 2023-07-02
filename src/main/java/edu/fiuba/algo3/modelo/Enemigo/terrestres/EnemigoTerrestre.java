package edu.fiuba.algo3.modelo.Enemigo.terrestres;

import edu.fiuba.algo3.modelo.Enemigo.EnemigoConVida;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.descriptors.EnemigoDescriptor;
import edu.fiuba.algo3.modelo.descriptors.EnemigoConVidaDescriptor;
import edu.fiuba.algo3.Logger;

public abstract class EnemigoTerrestre extends EnemigoConVida {

    private int ataqueMaximo;

    public EnemigoTerrestre(int vida, int velocidad, int ataqueMaximo) {
        super(vida, velocidad);
        this.ataqueMaximo = ataqueMaximo;
    }

    public EnemigoDescriptor describir(){
        return new EnemigoConVidaDescriptor(this.toString(),
            "terrestre",
            String.valueOf(velocidad), String.valueOf(vida),"ataca jugador con "+String.valueOf(ataqueMaximo));
    }

    public boolean atacadoPorTrampa(){
        if(this.velocidad == 1){
            return true;
        }
        this.velocidad = this.velocidad/2;
        return true;
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
        Logger.info(this,"llego al final atacando al jugador. Danio",String.valueOf(this.ataqueMaximo));
        jugador.recibirAtaque(this.ataqueMaximo);

    }

}
