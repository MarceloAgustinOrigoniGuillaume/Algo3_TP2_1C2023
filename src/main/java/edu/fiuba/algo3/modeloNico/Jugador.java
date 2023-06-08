package edu.fiuba.algo3.modeloNico;

import edu.fiuba.algo3.modeloNico.Defensas.Estructura;

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

    public void recibirAtaque(int damege) {
        vida = vida- damege;
        if(vida < 0 ){
            vida = 0;
        }
    }
}
