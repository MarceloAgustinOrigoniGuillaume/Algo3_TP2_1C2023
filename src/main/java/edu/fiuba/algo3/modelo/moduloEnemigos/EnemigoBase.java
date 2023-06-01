package edu.fiuba.algo3.modelo.moduloEnemigos;

import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;


public abstract class EnemigoBase implements Enemigo{

	protected int vida;
	protected int atk;
	protected int velocidad;
	protected int creditosAlMorir;
	protected Posicion pos;
	protected Jugador jugadorAsociado;
	public EnemigoBase(Posicion pos, Jugador jugador,
		int vida, int atk, int velocidad, int creditosAlMorir){
		this.pos = pos;
		this.vida = vida;
		this.atk= atk;
		this.velocidad = velocidad;
		jugadorAsociado = jugador;
		this.creditosAlMorir = creditosAlMorir;


	}

	public int obtenerCreditosMuerte(){
		return creditosAlMorir;
	} 


	public boolean estaMuerto(){
		return vida <= 0;
	}

	public boolean recibirDamage(int dmg){
		if(estaMuerto()){
			return true;
		}

		vida -= dmg;
		if(vida <=0){
			vida = 0;
			// murio, denle la recompensa.... no deberia realmente
			// pasar aca... pero para tener algo funcional
			jugadorAsociado.ganoCreditos(obtenerCreditosMuerte());
		}

		return estaMuerto();
	}

	public boolean accionar(Mapa mapa, Jugador jugador){
		return false;
	}
}