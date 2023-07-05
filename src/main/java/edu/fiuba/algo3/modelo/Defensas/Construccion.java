package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import java.util.ArrayList;

public interface Construccion{
	boolean estaActiva();
	void accionar(Mapa mapa, Coordenada desde);
    boolean posicionarEn(Celda celda);

}