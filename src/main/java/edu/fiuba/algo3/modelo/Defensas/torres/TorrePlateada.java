package edu.fiuba.algo3.modelo.Defensas.torres;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.EstadoConstruyendo;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;
import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;
import edu.fiuba.algo3.modelo.descriptors.AtaqueAEnemigo;

public class TorrePlateada extends Defensa {

    public final static String TORRE_TYPE = "TorrePlateada";
    private final int tiempoConstruccion;

    public TorrePlateada(int turnosParaConstruccion) {
        super(new EstadoConstruyendo(turnosParaConstruccion));
        this.tiempoConstruccion = turnosParaConstruccion;
    }
    public TorrePlateada() {
        this(2);
    }

    @Override
    public int costo() {
        return 20;
    }

    public int getTiempoConstruccion() {
        return tiempoConstruccion;
    }
    public int ataque(){
        return 2;
    }
    public int obtenerRango(){
        return 5;
    }

    // ataca al primer enemigo que pueda serlo
    // retorna false porque no debe seguir atacando.
    @Override
    public boolean atacar(ArrayList<Enemigo> enemigos, OnAttackListener listener) {
        for (Enemigo enemigo : enemigos){
            if(enemigo.atacadoPorTorre(ataque())){
                Logger.Log(this,"atacando a enemigo en rango",enemigo);
                listener.onAttack(new AtaqueAEnemigo(enemigo.toString(), TORRE_TYPE));

                return false; // fue atacado, solo ataca a uno. false == no sigas con otras
            }
        }
        return true;
    }

    @Override
    public String toString(){
        return TORRE_TYPE;
    }
}
