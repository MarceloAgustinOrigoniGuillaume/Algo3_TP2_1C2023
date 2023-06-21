package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Defensas.Estructura;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Enemigo.SistemaVida;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.Logger;
import java.util.ArrayList;

public class Jugador implements SistemaVida, Mapa.OnEnemiesDiedListener{
    private int vida;
    private String nombre;
    private SistemaCreditos creditos;

    public Jugador(){
        vida=20;
        creditos = new SistemaCreditos(100);
    }






    // delegacion de creditos
    public void acreditarMuertos(ArrayList<Enemigo> muertos){
        for(Enemigo enemigo: muertos) {
            enemigo.acreditarseEn(creditos);
        }
    }


    public int obtenerCreditos() {
        return creditos.obtenerCreditos();
    }


    public boolean puedeCostear(Estructura enConstruccion) {
        return creditos.puedeCostear(enConstruccion);
    }

    public void costear(Estructura enConstruccion) {
        creditos.costear(enConstruccion);
    }



    // nombre
    public void asignarNombre(String nombre) {
        verificarNombre(nombre);
        this.nombre = nombre;
    }

    private void verificarNombre(String nombre) {
        if (nombre.length() < 6) {
            throw new RuntimeException(); // Aca tenemos que hacer un error custom.
        }
    }



    // recibir ataques.... 

    public int obtenerVida() {
        return vida;
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
