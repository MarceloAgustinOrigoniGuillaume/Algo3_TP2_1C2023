package edu.fiuba.algo3.modelo;

public class Jugador {
    private int vida;
    private int creditos;
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
}
