package edu.fiuba.algo3.modelo.moduloEnemigos;

import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;


public class Hormiga extends EnemigoBase{
	

	public Hormiga(Posicion pos, Jugador jugador){

		super(pos,jugador, 1, 1, 1, 1);

	}

	@Override
	public int obtenerCreditosMuerte(){
		// deberia delegar a un sistema de 
		// apreciacion, que haga lo de que mas de 10 hormigas muertas sume mas.

		return super.obtenerCreditosMuerte();
	} 

}


