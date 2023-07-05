package edu.fiuba.algo3.modelo.Enemigo.aereos;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;


public class Lechuza extends EnemigoAereo {
    private int vidaCambioMovimiento;
    private EstadoMovimiento estadoMovimiento;

    public Lechuza(){
        super(5,5);
        this.estadoMovimiento = new EstadoMovimientoInicial(this);
        this.vidaCambioMovimiento= vida/2;
    }

    public boolean moverse(Mapa mapa, Coordenada posicion){
        return (this.estadoMovimiento).ejecutarEstado(mapa, posicion);
    }

    @Override
    public void recibirAtaque(int danioRecibido) {


        int nueva_vida =this.vida - danioRecibido; 
        
        if(this.vida > vidaCambioMovimiento && nueva_vida <= vidaCambioMovimiento){
            this.estadoMovimiento = new EstadoMovimientoDiagonal(this);
        }

        this.vida = nueva_vida;
        Logger.info("El daño recibido es: "+danioRecibido);
    }

    public Enemigo copiar(){
        return new Lechuza();
    }

    @Override
    public String toString(){
        return "Lechuza";
    }

    //Pre: -
    //Post: Se usa para calcular si es posible que el jugador pierda a partir de los enemigos actuales. Lechuza no hace daño.
    @Override
    public int ataqueMaximo() {
        return 0;
    }

    //Pre: -
    //Post: -
    protected void atacarObjeto(Jugador jugador, Mapa mapa){
        Logger.info("Lechuza llego al final, atacando a la primer torre....");
        mapa.atacarPrimeraTorre();
    }
}