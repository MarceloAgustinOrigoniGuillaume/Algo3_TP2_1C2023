package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.modelo.Enemigo.terrestres.EnemigoTerrestre;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.Random;

public class Arania extends EnemigoTerrestre implements Monetizable{

	public Arania(){
        super(2,2);
	}

    @Override
    public int creditosDados(){
        return new Random().nextInt(10);
    }

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
