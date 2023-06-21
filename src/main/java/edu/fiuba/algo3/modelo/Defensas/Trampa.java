package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;

public class Trampa extends Defensa {

    public Trampa() {
        super(new EstadoConstruido());
    }

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
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
    public boolean atacar(ArrayList<Enemigo> enemigos) {
        for (Enemigo enemigo : enemigos){
            enemigo.atacadoPorTrampa();
        }
        return false;
    }

    @Override
    public int ataque() {
        return 0;
    }
}
