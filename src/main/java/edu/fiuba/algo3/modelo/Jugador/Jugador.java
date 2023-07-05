package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Defensas.Estructura;
import edu.fiuba.algo3.modelo.Mapa.OnEnemiesDiedListener;
import edu.fiuba.algo3.modelo.Enemigo.SistemaVida;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.Logger;

import java.util.ArrayList;

public class Jugador implements SistemaVida, OnEnemiesDiedListener{
    private int vida;
    private SistemaCreditos creditos;
    private modificacion_vida obsver_vida = (String vida)->{};
    private modificacion_creditos observer_creditos = (String creditos)->{};
    public interface modificacion_vida{
        void update_vida(String vida);
    }
    public interface modificacion_creditos{
        void update_creditos(String Creditos);
    }
    public Jugador(){
        vida=20;
        creditos = new SistemaCreditos(100);
    }
    public void acreditarMuertos(ArrayList<Enemigo> muertos){ // delegacion de creditos
        for(Enemigo enemigo: muertos) {
            enemigo.acreditarseEn(creditos);
        }
        observer_creditos.update_creditos(String.valueOf(creditos.obtenerCreditos()));
    }
    public int obtenerCreditos() {
        return creditos.obtenerCreditos();
    }

    public boolean puedeCostear(Estructura enConstruccion) {
        return creditos.puedeCostear(enConstruccion);
    }
    public void costear(Estructura enConstruccion) {
        creditos.costear(enConstruccion);
        observer_creditos.update_creditos(String.valueOf(creditos.obtenerCreditos()));
    }
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
        obsver_vida.update_vida(String.valueOf(vida));
    }

    public void setObserver_creditos(modificacion_creditos observer_creditos) {
        if(observer_creditos == null){
            this.observer_creditos = (String creditos)->{};
            return;
        }
        this.observer_creditos = observer_creditos;
    }
    public void setObsver_vida(modificacion_vida obsver_vida){
        if(obsver_vida == null){
            this.obsver_vida = (String vida)->{};
            return;
        }
        this.obsver_vida = obsver_vida;
    }
}
