package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Hormiga extends Enemigo {

	public Hormiga(){
        super(1,1); // vida , velocidad
	}


    @Override
    public void reducirVelocidad() {
        this.velocidad = (int)Math.floor(this.velocidad / 2);
    }


    public int creditosDados(){
    	return 1;
    }

    public Enemigo copiar(){
    	return new Hormiga();
    }

    @Override
    public void incrementarContadorDePasos(){

    }

    @Override
    public int ataque(Mapa mapa) {
        return 0;
    }

    @Override
    public String toString(){
        return "Hormiga";
    }

    @Override
    public int ataque() {
        return 1;
    }
}
