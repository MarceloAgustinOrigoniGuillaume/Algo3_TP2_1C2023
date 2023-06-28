package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;
import edu.fiuba.algo3.modelo.descriptors.AtaqueAEnemigo;

public class Trampa extends Defensa {
    public final static String TRAMPA_TYPE = "Trampa";
    public Trampa() {
        super(new EstadoTrampa(3));
    }
    public boolean posicionarEn(Celda celda){
        return celda.guardar(this);
    }
    @Override
    public int obtenerRango() {
        return 0;
    }

    @Override
    public int costo() {
        return 25;
    }

    // ataca a tooodos los enemigos que reciban.
    // retorna false porque no debe seguir atacando.
    @Override
    public boolean atacar(ArrayList<Enemigo> enemigos,OnAttackListener listener) {


        Logger.info("trampa relantizando enemigos");
        boolean ataco = false;
        for (Enemigo enemigo : enemigos){
            ataco = enemigo.atacadoPorTrampa() || ataco;
        }

        if(ataco){
            listener.onAttack(new AtaqueAEnemigo());
        }
        return false;
    }
    @Override
    public int ataque() {
        return 0;
    }

    @Override
    public String toString(){
        return TRAMPA_TYPE;
    }
}
