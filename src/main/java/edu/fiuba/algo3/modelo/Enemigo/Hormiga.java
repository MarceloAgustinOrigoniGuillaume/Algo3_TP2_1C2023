package edu.fiuba.algo3.modelo.Enemigo;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Hormiga implements Enemigo {

	private int vida;
    private int velocidad = 1;
	public Hormiga(){

        this.vida = 1;
	}

	public int velocidad(){

        return this.velocidad;
	}

    @Override
    public void reducirVelocidad() {
        this.velocidad = (int)Math.floor(this.velocidad / 2);
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
    	return 1;
    }

    public Enemigo copiar(){
    	return new Hormiga();
    }

    @Override
    public void incrementarContadorDePasos(){

    }

    @Override
    public int ataque(Mapa mapa) {
        return 0;
    }

    @Override
    public String toString(){
        return "Hormiga";
    }

    @Override
    public int ataque() {
        return 1;
    }
}
