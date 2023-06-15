package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Arania implements Enemigo {

	private int vida;
    private int velocidad = 2;

	public Arania(){
		this.vida = 2;
	}


	public int velocidad(){
        return this.velocidad;
	}

    @Override
    public void reducirVelocidad() {
        this.velocidad = (int)Math.floor(this.velocidad / 2);
    }

    public int ataque(){
        return 2;
		//target.recibirAtaque(2); // hace dos de dmg
	}

    public boolean estaMuerto(){
        return vida <= 0;
    }

    @Override
    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info("El daño recibido es: "+danioRecibido);

    }

    public int creditosDados(){
    	return 6;
    }


    public Enemigo copiar(){
    	return new Arania();
    }


    @Override
    public void incrementarContadorDePasos(){

    }
    @Override
    public String toString(){
        return "Araña";
    }

}
