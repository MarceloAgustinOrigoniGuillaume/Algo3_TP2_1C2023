package edu.fiuba.algo3.modelo.Enemigo.aereos;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.SistemaVida;
import edu.fiuba.algo3.modelo.Enemigo.EnemigoConVida;
import edu.fiuba.algo3.modelo.Celdas.CeldaConEnemigos;
import edu.fiuba.algo3.modelo.descriptors.EnemigoDescriptor;
import edu.fiuba.algo3.modelo.descriptors.EnemigoConVidaDescriptor;

public abstract class EnemigoAereo extends EnemigoConVida {//implements Monetizable {

    public EnemigoAereo(int vida, int velocidad) {
        super(vida, velocidad);
    }

    public boolean posicionarEn(CeldaConEnemigos celda){
        return celda.guardar(this);
    }

    public EnemigoDescriptor describir(){
        return new EnemigoConVidaDescriptor(this.toString(),
            "aereo",
            String.valueOf(velocidad), String.valueOf(vida),"ataca torres");
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