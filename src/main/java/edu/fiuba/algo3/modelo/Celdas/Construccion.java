package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import java.util.ArrayList;

public interface Construccion extends Posicionable{
	int obtenerRango();
	boolean estaActiva();
	void accionar(Mapa mapa, Coordenada desde);
}