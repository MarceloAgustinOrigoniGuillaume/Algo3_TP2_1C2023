package edu.fiuba.algo3.modelo.Enemigo.terrestres;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;

public class Hormiga extends EnemigoTerrestre implements Monetizable {

	public Hormiga(){
        super(1,1); // vida , velocidad
	}

    @Override
    public int creditosDados(){
    	return 1;
    }

    public Enemigo copiar(){
        return new Hormiga();
    }
    @Override
    public String toString(){
        return "Hormiga";
    }

    //Pre: -
    //Post: Se usa para calcular si es posible que el jugador pierda a partir de los enemigos actuales. Hormiga hace daño 1.
    @Override
    public int ataque() {
        return 1;
    }
}
