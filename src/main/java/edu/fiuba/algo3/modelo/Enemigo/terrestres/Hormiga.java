package edu.fiuba.algo3.modelo.Enemigo.terrestres;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Billetera;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;

public class Hormiga extends EnemigoTerrestre {

	public Hormiga(){
        super(1,1, 1);
	}

    @Override
    public int creditosDados(){

        Billetera billetera = Billetera.getInstance();
        if(billetera.agregarHormigaMatada() > 10) {
            billetera.agregarCreditos(2);
            return 2;
        }
        billetera.agregarCreditos(1);
        return 1;
    }

    @Override
    public String toString(){
        return "Hormiga";
    }


    public Enemigo copiar(){
        return new Hormiga();
    }
}
