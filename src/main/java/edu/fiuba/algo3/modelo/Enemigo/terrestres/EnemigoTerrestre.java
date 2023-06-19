package edu.fiuba.algo3.modelo.Enemigo.terrestres;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;

public abstract class EnemigoTerrestre extends Enemigo {
    public EnemigoTerrestre(int vida, int velocidad) {
        super(vida, velocidad);
    }

    public void reducirVelocidad(){
        this.velocidad = (int)Math.floor(this.velocidad / 2);
    }

    @Override
    public Enemigo copiar() {
        return null;
    }

}
