package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import java.util.ArrayList;

public interface Construccion extends Ataque,Posicionable{
	int obtenerRango();
	boolean estaActiva();
	ArrayList<Unidad> accionar(Mapa mapa, Coordenada desde);
}