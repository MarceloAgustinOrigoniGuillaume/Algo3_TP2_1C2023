package edu.fiuba.algo3.modelo.Enemigo.subterraneos;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Topo extends EnemigoSubterraneo implements Monetizable {

    private int turno;
    private int contadorMovimientos;

    public Topo(int turnoActual){
        super(1, 1);
        this.turno = turnoActual;
        this.contadorMovimientos = 0;
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
    // Post: Al no poder ser matado, el topo nunca da creditos.
    @Override
    public int creditosDados() {
        return 0;
    }

    //Pre: -
    // Post: El topo nunca muere, hace un daño a la torre al llegar y desaparece.
    @Override
    public boolean estaMuerto() {
        return false;
    }
    //Pre: -
    // Post: -
    @Override
    public int ataque() {
        if((this.turno)%2 == 0){
            return 5;
        }
        return 2;
    }
    //Pre: -
    // Post: -
    @Override
    public void recibirAtaque(int danioRecibido) {
        Logger.info("El daño recibido es: 0");
    }
    
    @Override
    public Enemigo copiar() {
        return new Topo(this.turno);
    }


}

