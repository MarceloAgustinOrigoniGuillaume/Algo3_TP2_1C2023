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

    //Pre: -
    //Post: Se usa para calcular si es posible que el jugador pierda a partir de los enemigos actuales. Araña hace daño 2.
    public int ataque(){
        return 2;
	}

    public Enemigo copiar(){
    	return new Arania();
    }

    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        if(this.vida == 0){
            this.creditosDados();
        }
        Logger.info(" El daño recibido es: "+danioRecibido);
    }
    @Override
    public String toString(){
        return "Araña";
    }

}
