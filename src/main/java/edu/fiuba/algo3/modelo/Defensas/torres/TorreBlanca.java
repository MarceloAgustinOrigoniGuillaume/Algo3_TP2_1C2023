package edu.fiuba.algo3.modelo.Defensas.torres;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.EstadoConstruyendo;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;
import edu.fiuba.algo3.Logger;

public class TorreBlanca extends Defensa {
    public final static String TORRE_TYPE = "TorreBlanca";

    public TorreBlanca(int turnosParaConstruccion) {

        super(new EstadoConstruyendo(turnosParaConstruccion));
    }
    public TorreBlanca() {

        this(1);
    }
    @Override
    public int costo() {
        return 10;
    }
    public int ataque(){
        return 1;
    }
    public int obtenerRango(){
        return 3;
    }

    // ataca al primer enemigo que pueda serlo
    // retorna false porque no debe seguir atacando.
    @Override
    public boolean atacar(ArrayList<Enemigo> enemigos) {
        for (Enemigo enemigo : enemigos){
            if(enemigo.atacadoPorTorre(ataque())){
                Logger.Log(this,"atacando a enemigo en rango",enemigo);        
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