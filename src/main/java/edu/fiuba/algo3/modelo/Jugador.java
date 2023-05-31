package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int vida;
    private int creditos;
    public Jugador(String nombre){
        verificarNombre(nombre);
        this.nombre = nombre;
        vida=20;
        creditos=100;
    }

    private void verificarNombre(String nombre) {
        if (nombre.length() < 6) {
            throw new RuntimeException();
        }
    }
    public int obtenerCreditos() {
        return creditos;
    }

    public int obtenerVida() {
        return vida;
    }
}
