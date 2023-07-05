package edu.fiuba.algo3.modelo.Enemigo.subterraneos;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import edu.fiuba.algo3.modelo.descriptors.EnemigoDescriptor;
import edu.fiuba.algo3.modelo.descriptors.TopoDescriptor;

public class Topo extends EnemigoSubterraneo {
    private int turnoInicial;
    private int contadorMovimientos;

    public Topo(int turnoActual){
        super(1, 5);
        this.turnoInicial = turnoActual;
        this.contadorMovimientos = 0;
    }
    //Pre: -
    // Post: -
    @Override
    public boolean moverse(Mapa mapa, Coordenada posicion) {
        incrementarContadorDePasos();
        return super.moverse(mapa, posicion);
    }
    //Pre: -
    // Post: -
    public void incrementarContadorDePasos() {

        this.contadorMovimientos++;
        if(this.contadorMovimientos > 5 && this.contadorMovimientos <= 10){
            this.velocidad = 2;
        }
        if(this.contadorMovimientos >= 11){
            this.velocidad = 3;
        }
    }
    //Pre: -
    //Post: -
    protected void atacarObjeto(Jugador jugador, Mapa mapa) {
    
        int ataque = this.ataqueMaximo;
        if((this.turnoInicial+this.contadorMovimientos) % 2 != 0){
            ataque = 2;
        }
        Logger.info(this,"llego al final atacando al jugador. Danio",String.valueOf(ataque));

        jugador.recibirAtaque(ataque);
    }
    
    @Override
    public Enemigo copiar() {
        return new Topo(this.turnoInicial);
    }

    public EnemigoDescriptor describir(){
        return new TopoDescriptor(String.valueOf(this.contadorMovimientos),String.valueOf(this.contadorMovimientos+this.turnoInicial),String.valueOf(this.velocidad));
    }
}


