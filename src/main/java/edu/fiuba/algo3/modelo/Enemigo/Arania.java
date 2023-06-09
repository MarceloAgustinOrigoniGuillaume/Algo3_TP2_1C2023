package edu.fiuba.algo3.modelo.Enemigo;

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

}
