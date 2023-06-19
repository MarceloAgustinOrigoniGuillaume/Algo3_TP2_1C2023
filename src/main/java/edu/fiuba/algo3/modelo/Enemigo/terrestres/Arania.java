package edu.fiuba.algo3.modelo.Enemigo.terrestres;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;

import java.util.Random;

public class Arania extends EnemigoTerrestre implements Monetizable {

	public Arania(){
        super(2,2, 2);
	}

    @Override
    public int creditosDados(){
        return new Random().nextInt(10);
    }

    //Pre: -
    //Post: Se usa para calcular si es posible que el jugador pierda a partir de los enemigos actuales. Araña hace daño 2.
    public int ataque(){
        return 2;
	}

    public Enemigo copiar(){
    	return new Arania();
    }

    @Override
    public String toString(){
        return "Araña";
    }

}
