package edu.fiuba.algo3.modelo.Enemigo.subterraneos;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Billetera;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Topo extends EnemigoSubterraneo {

    private int turno;
    private int contadorMovimientos;

    public Topo(int turnoActual){
        super(1, 1, 5);
        this.turno = turnoActual;
        this.contadorMovimientos = 0;
    }

    //Pre: -
    // Post: -
    @Override
    public boolean moverse(Mapa mapa, Coordenada posicion) {
        incrementarContadorDePasos();
        super.moverse(mapa, posicion);
        return false;
    }

    //Pre: -
    // Post: -
    public void incrementarContadorDePasos() {
        this.contadorMovimientos++;
        this.turno++;
    }

    //Pre: -
    // Post: -
    public int velocidad(){

        if(this.contadorMovimientos > 5 && this.contadorMovimientos <= 10){
            this.velocidad = 2;
        }
        if(this.contadorMovimientos >= 11){
            this.velocidad = 3;
        }
        return this.velocidad;
    }

    //Pre: -
    //Post: -
    protected void atacarObjeto(Jugador jugador, Mapa mapa) {
    
        int ataque = this.ataqueMaximo;
        if((this.turno) % 2 != 0){
            ataque = 2;
        }
        jugador.recibirAtaque(ataque);
    }

    //Pre: -
    // Post: El topo nunca muere, hace un daño a la torre al llegar y desaparece.
    public boolean estaMuerto() {
        return false;
    }
    
    @Override
    public Enemigo copiar() {
        return new Topo(this.turno);
    }

}


