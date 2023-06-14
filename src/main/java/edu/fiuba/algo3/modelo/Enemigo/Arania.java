package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.Logger;

public class Arania implements Enemigo {

	private int vida;
	public Arania(){
		vida = 2;
	}


	public int velocidad(){
		return 2;
	}

    public int ataque(){
        return 2;
		//target.recibirAtaque(2); // hace dos de dmg
	}

    public boolean estaMuerto(){
        return vida <= 0;
    }


	public void recibirAtaque(int damege) {
        vida = vida- damege;
        Logger.info("El daño recibido es: "+damege);
        // Aca capaz, queda mejor si la vida-damage =< 0 entonces que le pase un mensaje a juego o estado jugando que se termino el juego.
        if(estaMuerto()){
            vida = 0;
        }
    }

    public int creditosDados(){
    	return 6;
    }


    public Enemigo copiar(){
    	return new Arania();
    }

    @Override
    public String toString(){
        return "Araña";
    }

}
