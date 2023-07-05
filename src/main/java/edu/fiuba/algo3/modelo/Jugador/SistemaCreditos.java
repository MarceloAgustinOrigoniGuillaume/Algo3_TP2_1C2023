package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Defensas.Estructura;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;

public class SistemaCreditos{
    private int creditos;
    private int hormigas_muertas;

    public SistemaCreditos(int cantidad_inicial){
        hormigas_muertas = 0;
        creditos = cantidad_inicial;
    }
    public int obtenerCreditos() {
        return creditos;
    }

    public void acreditarHormiga(int creditos_base){

        hormigas_muertas+=1;
        if(hormigas_muertas >= 10){
            creditos_base *= 2;
        }
        sumarCreditos(creditos_base);
    }
    public void acreditarArania(int creditos_base){
        sumarCreditos(creditos_base);
    }

    private void sumarCreditos(int creditos){
        this.creditos += creditos;
    }

    public boolean puedeCostear(Estructura enConstruccion) {
        return (creditos >= enConstruccion.costo());
    }

    public void costear(Estructura enConstruccion) {
        if(!puedeCostear(enConstruccion)){
           return;
        }
        creditos-= enConstruccion.costo();
    }
}
