package edu.fiuba.algo3.modelo.Enemigo;

public class Hormiga implements Enemigo {

	private int vida;
	public Hormiga(){
		vida = 1;
	}

	public int velocidad(){
		return 1;
	}

    public int ataque(){
        return 1;
		//target.recibirAtaque(1); // hace uno de dmg
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
    	return 1;
    }

    public Enemigo copiar(){
    	return new Hormiga();
    }

    @Override
    public String toString(){
        return "Hormiga";
    }
}
