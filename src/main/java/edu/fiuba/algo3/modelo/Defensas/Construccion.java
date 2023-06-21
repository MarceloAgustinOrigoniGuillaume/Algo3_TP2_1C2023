package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.Posicionable;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import java.util.ArrayList;

public interface Construccion extends Posicionable{
	boolean estaActiva();
	void accionar(Mapa mapa, Coordenada desde);

}