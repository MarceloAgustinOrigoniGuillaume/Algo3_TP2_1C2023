package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Defensas.Estructura;
import edu.fiuba.algo3.modelo.Celdas.SistemaVida;

public class Jugador implements SistemaVida{
    private int vida;
    private int creditos;

    private String nombre;
    public Jugador(){
        vida=20;
        creditos=100;
    }
    public int obtenerCreditos() {
        return creditos;
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
        return (creditos >= enConstruccion.costo());
    }

    public void costear(Estructura enConstruccion) {
        if(!puedeCostear(enConstruccion)){
            /*
            la idea esta que devuelva un error;
             */
           return;
        }
        creditos -= enConstruccion.costo();
    }


    public void ganoCreditos(int creditos){
        this.creditos+= creditos;
    }

    public boolean estaMuerto(){
        return vida <= 0;
    }

    public void recibirAtaque(int damege) {
        vida = vida- damege;
        // Aca capaz, queda mejor si la vida-damage =< 0 entonces que le pase un mensaje a juego o estado jugando que se termino el juego.
        if(estaMuerto()){
            vida = 0;
        }
    }
}
