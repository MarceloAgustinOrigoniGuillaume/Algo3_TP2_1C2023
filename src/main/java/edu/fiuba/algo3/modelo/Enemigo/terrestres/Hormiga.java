package edu.fiuba.algo3.modelo.Enemigo.terrestres;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador.SistemaCreditos;

public class Hormiga extends EnemigoTerrestre {

	public Hormiga(){
        super(1,1, 1);
	}

    @Override
    public void acreditarseEn(SistemaCreditos sistema){
        sistema.acreditarHormiga(1);
    }    

    @Override
    public String toString(){
        return "Hormiga";
    }


    public Enemigo copiar(){
        return new Hormiga();
    }
}
