package edu.fiuba.algo3.modelo.Enemigo.terrestres;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.SistemaCreditos;

import java.util.Random;

public class Arania extends EnemigoTerrestre {

	public Arania(){
        super(2,2, 2);
	}

    @Override
    public void acreditarseEn(SistemaCreditos sistema){
        sistema.acreditarArania(new Random().nextInt(10));
    }    

    @Override
    public String toString(){
        return "Arania";
    }

    public Enemigo copiar(){
    	return new Arania();
    }
}
