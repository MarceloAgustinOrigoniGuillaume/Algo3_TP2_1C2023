package edu.fiuba.algo3.modelo.moduloEnemigos;

//import edu.fiuba.algo3.modelo.moduloMapa.GameEntity;
import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Jugador;


public interface Enemigo extends Atacable{
	boolean accionar(Mapa mapa, Jugador jugador);
}