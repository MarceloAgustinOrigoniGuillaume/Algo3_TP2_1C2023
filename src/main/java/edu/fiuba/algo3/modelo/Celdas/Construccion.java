package edu.fiuba.algo3.modelo.Celdas;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;

public interface Construccion extends Ataque,Posicionable{
	int obtenerRango();
	boolean estaActiva();
	ArrayList<Unidad> accionar(ArrayList<Unidad> enemigos);

}