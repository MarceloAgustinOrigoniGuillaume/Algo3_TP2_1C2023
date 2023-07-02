package edu.fiuba.algo3.modelo.Enemigo.terrestres;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador.SistemaCreditos;

import java.util.Random;

public class Arania extends EnemigoTerrestre {

	public Arania(){
        super(2,2, 2);
	}

    @Override
    public void acreditarseEn(SistemaCreditos sistema){
        sistema.acreditarArania(new Random().nextInt(9)+1);
    }    

    @Override
    public String toString(){
        return "Arania";
    }

    public Enemigo copiar(){
    	return new Arania();
    }
}
