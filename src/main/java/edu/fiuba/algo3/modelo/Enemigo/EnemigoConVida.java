package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.Logger;

public abstract class EnemigoConVida extends Enemigo implements SistemaVida {

    protected int vida;
    public EnemigoConVida(int vida, int velocidad) {
        super(velocidad);
        this.vida = vida;
    }

    public boolean estaMuerto(){
        return vida <= 0;
    }

    public boolean atacadoPorTorre(int dmg){
        recibirAtaque(dmg);
        return true;
    }

    @Override
    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info(this.toString()+" recibio dmg : "+danioRecibido);
        if (estaMuerto()){
            vida = 0;
            Logger.info(this.toString()+" murio ");
        }
    }
}
