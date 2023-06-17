package edu.fiuba.algo3.modelo.Enemigo.aereos;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;


public class Lechuza extends EnemigoAereo {

    private int vida;
    private int vidaCambioMovimiento;
    private int velocidad = 1;
    public Lechuza(){
        super(5, 5);
    }

    public int velocidad(){

        return this.velocidad;
    }

    @Override
    public void reducirVelocidad() {
        this.velocidad = (int)Math.floor(this.velocidad / 2);
    }

    public boolean estaMuerto(){
        return vida <= 0;
    }

    @Override
    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info("El daño recibido es: "+danioRecibido);
    }

    public int creditosDados(){
        return 1;
    }

    public Enemigo copiar(){
        return new Lechuza();
    }

    @Override
    public void incrementarContadorDePasos(){

    }

    @Override
    public int ataque(Mapa mapa) {
    return 0;
    }

    @Override
    public String toString(){
        return "Lechuza";
    }

    @Override
    public int ataque() {

            //Lechuza le dice a mapa que destruya una de las torres.
            //mapa.atacarPrimeraTorre();

        return 0;
    }

    public void atacar(Jugador jugador, Mapa mapa){
        mapa.atacarPrimeraTorre();
    }
}
