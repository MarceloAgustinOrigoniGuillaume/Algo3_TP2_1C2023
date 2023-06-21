package edu.fiuba.algo3.modelo.Enemigo.aereos;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Billetera;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;


public class Lechuza extends EnemigoAereo {

    private int vida;
    private int vidaCambioMovimiento;
    private int velocidad;
    private EstadoMovimiento estadoMovimiento;

    public Lechuza(){
        super(5,5);
        this.estadoMovimiento = new EstadoMovimientoInicial(this);
        this.vidaCambioMovimiento= vida/2;
    }

    public int velocidad(){
        return this.velocidad;
    }

    public boolean moverse(Mapa mapa, Coordenada posicion){

        if(vida <= vidaCambioMovimiento){
            this.estadoMovimiento = new EstadoMovimientoDiagonal(this);
        }
        return (this.estadoMovimiento).ejecutarEstado( mapa, posicion);
    }

    @Override
    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info("El daño recibido es: "+danioRecibido);
    }

    //Pre: -
    //Post: La lechuza, de momento, no dice que de creditos al jugador.
    @Override
    public int creditosDados(){
        Billetera billetera = Billetera.getInstance();
        billetera.agregarCreditos(0);
        return 0;
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
        mapa.atacarPrimeraTorre();
    }
}