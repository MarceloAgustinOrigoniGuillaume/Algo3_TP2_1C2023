package edu.fiuba.algo3.modelo.moduloEnemigos;

import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modelo.Jugador;


public class Hormiga extends EnemigoBase{

	public Spider(Posicion pos, Jugador jugador){

		super(pos,jugador, 2, 2, 2, 2);

	}


	@Override
	public int obtenerCreditosMuerte(){
		// deberia retornar de forma random

		return super.obtenerCreditosMuerte();
	} 

}


