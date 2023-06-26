package edu.fiuba.algo3.modelo.Defensas.torres;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.EstadoConstruyendo;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;

public class TorrePlateada extends Defensa {

    public final static String TORRE_TYPE = "TorrePlateada";

    public TorrePlateada(int turnosParaConstruccion) {
        super(new EstadoConstruyendo(turnosParaConstruccion));
    }
    public TorrePlateada() {
        this(2);
    }

    @Override
    public int costo() {
        return 20;
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
    public boolean atacar(ArrayList<Enemigo> enemigos) {
        for (Enemigo enemigo : enemigos){
            if(enemigo.atacadoPorTorre(ataque())){
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
