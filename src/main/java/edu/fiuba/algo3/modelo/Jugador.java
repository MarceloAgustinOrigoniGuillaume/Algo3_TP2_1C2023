package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Defensas.Estructura;
import edu.fiuba.algo3.modelo.Enemigo.SistemaVida;
import edu.fiuba.algo3.Logger;

public class Jugador implements SistemaVida{
    private int vida;
    private Billetera creditos;
    private String nombre;

    public Jugador(){
        vida=20;
        Billetera billetera = Billetera.getInstance();
        billetera.restablecerCreditos();
        billetera.agregarCreditos(100);
    }
    public int obtenerCreditos() {
        Billetera billetera = Billetera.getInstance();
        return billetera.obtenerCreditos();
    }

    public int obtenerVida() {
        return vida;
    }

    public void asignarNombre(String nombre) {
        verificarNombre(nombre);
        this.nombre = nombre;
    }

    private void verificarNombre(String nombre) {
        if (nombre.length() < 6) {
            throw new RuntimeException(); // Aca tenemos que hacer un error custom.
        }
    }

    public boolean puedeCostear(Estructura enConstruccion) {
        Billetera billetera = Billetera.getInstance();
        return (billetera.obtenerCreditos() >= enConstruccion.costo());
    }

    public void costear(Estructura enConstruccion) {
        Billetera billetera = Billetera.getInstance();
        if(!puedeCostear(enConstruccion)){
           return;
        }
        billetera.reducirCreditos(enConstruccion.costo());
    }

    public boolean estaMuerto(){
        return vida <= 0;
    }

    public void recibirAtaque(int damege) {
        Logger.Log("jugador recibio damage "+String.valueOf(damege));
        vida = vida- damege;
 
        // Aca capaz, queda mejor si la vida-damage =< 0 entonces que le pase un mensaje a juego o estado jugando que se termino el juego.
        if(estaMuerto()){
            vida = 0;
        }
    }
}
