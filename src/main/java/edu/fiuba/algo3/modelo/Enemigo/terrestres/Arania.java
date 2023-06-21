package edu.fiuba.algo3.modelo.Enemigo.terrestres;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Billetera;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;

import java.util.Random;

public class Arania extends EnemigoTerrestre {

	public Arania(){
        super(2,2, 2);
	}

    @Override
    public int creditosDados(){

        Billetera billetera = Billetera.getInstance();
        int valorCreditos = new Random().nextInt(10);

        billetera.agregarCreditos(valorCreditos);
        return valorCreditos;
    }


    @Override
    public String toString(){
        return "Araña";
    }

    public Enemigo copiar(){
    	return new Arania();
    }
}
