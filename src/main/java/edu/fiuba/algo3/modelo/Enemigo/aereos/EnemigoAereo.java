package edu.fiuba.algo3.modelo.Enemigo.aereos;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.SistemaVida;
import edu.fiuba.algo3.modelo.Enemigo.EnemigoConVida;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public abstract class EnemigoAereo extends EnemigoConVida {//implements Monetizable {

    public EnemigoAereo(int vida, int velocidad) {
        super(vida, velocidad);
    }

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }


    // No es atacado por trampa
    @Override
    public boolean atacadoPorTrampa(){
        return false;
    }


    @Override
    public String toString(){
        return "Enemigo Aereo";
    }
}
